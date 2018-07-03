package com.migen.myiot.service;



import com.migen.myiot.entity.*;
import com.migen.myiot.utils.DateUtils;
import com.migen.myiot.utils.MapUtils;
import com.migen.myiot.utils.Utils;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.modbus.FunctionCode;
import io.netty.channel.socket.SocketChannel;

import java.util.Date;
import java.util.Map;

import static com.migen.myiot.enums.Constants.HM_QUENEN_DEVICE;

/**
 * Created by Administrator on 2017/4/1.
 */
public class DealMessageService  {

    /**
     * 处理序号
     * @param moduleId
     * @param socket
     * @return
     */
    public static int dealSerialNum(String moduleId, Device device, SocketChannel socket) {
        if(	device==null){
            String didShow=DeviceService.genDidShow();
            String spwd=DeviceService.genSPwd();
            device=new Device();
            device.setModuleId(moduleId);
            device.setDidShow(didShow);
            device.setSpwd(spwd);
            device.setName("unknown");
            device.setAddress("");
            device.setGenCom("");
            device.setPlcName("");
            if (Utils.emptyStr(device.getUseCom()))
            {
                device.setUseCom( "unknown" + (int)(Math.random()*10000));
            }
            device.setDt(DateUtils.getDateTime(new Date()));
            DeviceService.insertDevice(device);
        }
        // 存储socket
        activeSocket(device.getDid(), socket);

        //运行时长
        WorkTime workTime=new WorkTime();
        workTime.setDid(device.getDid());
        workTime.setStartTime(new Date());
        workTime.setStatus(1);
        workTime.setDt(DateUtils.getDateTime(new Date()));
        WorkTimeService.insertWorkTime(workTime);

        return device.getDid();
    }

    public static void activeSocket(int did, SocketChannel socket)
    {
        Device device= DeviceService.getDeviceByDId(did);
        if(Constants.HM_SOCKET.get(did)!=null){
            Constants.HM_SOCKET.remove(did);
        }
        Constants.HM_SOCKET.put(did, socket);
        HM_QUENEN_DEVICE.put(did,false);
        DeviceService.updateSocket(did,1,1);
    }

    public static void inactiveSocket(int did,SocketChannel socket){
        //channel失效，从Map中移除
        Constants.HM_SOCKET.remove(did);
        Constants.HM_QUENEN_DEVICE.remove(did);
        DeviceService.updateSocket(did,2,2);
        //运行时长
        WorkTime workTime=new WorkTime();
        workTime.setDid(did);
        workTime.setEndTime(new Date());
        WorkTimeService.updateWorkTime(workTime);
    }

    /**
     * 锁定机器
     * @param did
     * @param issue
     * @param result
     */
    public static void dealLock(int did, Issue issue, String result){
        if(DeviceLockService.isExistDeviceLock(did,issue.getItype())){
            return;
        }
        DeviceLock deviceLock=new DeviceLock();
        deviceLock.setDid(did);
        deviceLock.setLtype(issue.getItype());
        deviceLock.setStatus(2);
        deviceLock.setDt(DateUtils.getDateTime(new Date()));
        int cnt=DeviceLockService.insertDeviceLock(deviceLock);
        DeviceService.updateStatus(did,Constants.DEVICE_LOCK);
    }

    /**
     * 解除锁定
     * @param did
     * @param issue
     * @param result
     */
    public static void dealUnLock(int did, Issue issue,String result){
        DeviceLock deviceLock=new DeviceLock();
        deviceLock.setDid(did);
        int cnt=DeviceLockService.deviceUnLock(deviceLock);
        DeviceService.updateStatus(did,Constants.DEVICE_UNLOCK);
    }


    /**
     * 处理定位
     * @param did
     * @param result
     */
    public static void dealPotision(int did,String result){
        String location=result.split(":")[1];
        location=location.split("#")[0];
        location=location.substring(0,location.length()-1);

        Device device=DeviceService.getDeviceByDId(did);
        LocationRight ltb=new LocationRight();
        ltb.setDid(device.getDid());
        ltb.setDidShow(device.getDidShow());

       //DTU定位
        String[] coordinate=location.split(",");
        ltb.setLongitude(Double.parseDouble(coordinate[0]));
        ltb.setLatitude(Double.parseDouble(coordinate[1]));
        //获取地址
        String transferLocation= MapUtils.convertGPSCoordinate(location);
        if(!Utils.emptyStr(transferLocation)){
            MapUtils.getMapLocation(transferLocation,ltb);
        }
        LocationRight locationRight=LocationRightService.getLocationRightByDid(device.getDid());
        if(locationRight==null){
            ltb.setStatus(1);
            LocationRightService.insertLocationRight(ltb);
        }else{
            double[] curLocation= new double[2];
            curLocation[0] = locationRight.getLongitude();
            curLocation[1] = locationRight.getLatitude();
            int distance=Utils.calDistanceInMeter(ltb.getLatitude(),ltb.getLongitude(),curLocation[1],curLocation[0]);
            if(distance> Constants.LOCATION_DISTANCE_MAX){
                //更新位置
                locationRight.setStatus(3);
                LocationRightService.updateStatus(locationRight);
                ltb.setStatus(1);
                LocationRightService.insertLocationRight(ltb);
                //插入警告
                Warn warn=new Warn();
                warn.setDid(device.getDid());
                warn.setWtype(9);
                WarnType warnType=WarnTypeService.getWarnTypeById(warn.getWtype());
                warn.setWtname(warnType.getWtname());
                warn.setFromthing(1);
                warn.setErrpri(4);
                warn.setCiduse(device.getCiduse());
                warn.setDt(new Date());
               // warn.setCompany(device.getComuse());
                WarnService.insertWarn(warn);
            }
        }

    }

    /**
     *预设产量
     * @param did
     * @param issue
     * @param result
     */
    public static void dealInstallYield(int did, Issue issue,String result){
        int functionCode=  Integer.parseInt(result.substring(2,4),16);
        if(functionCode==(int) FunctionCode.READ_HOLDING_REGISTERS){
            int length=Integer.parseInt(result.substring(4,6),16);
            String highvalue=result.substring(6,length+6);
            String lowvalue=result.substring(length+6,length*2+6);
            int installYield=Integer.parseInt(lowvalue+highvalue,16);
            DeviceService.updateInstallYield(did,installYield);
        }
    }

    /**
     *产量记数
     * @param did
     * @param issue
     * @param result
     */
    public static void dealRealYield(int did, Issue issue,String result){
        int functionCode=  Integer.parseInt(result.substring(2,4),16);
        if(functionCode==(int) FunctionCode.READ_HOLDING_REGISTERS){
            int length=Integer.parseInt(result.substring(4,6),16);
            String highvalue=result.substring(6,length+6);
            String lowvalue=result.substring(length+6,length*2+6);
            int realYield=Integer.parseInt(lowvalue+highvalue,16);
            DeviceService.updateRealYield(did,realYield);
        }
    }

    /**
     *增加产量
     * @param did
     * @param issue
     * @param result
     */
    public static void dealAddNum(int did, Issue issue, String result){
        Stuff stuff=new Stuff();
        stuff.setDid(did);
        stuff.setNumAll(Integer.parseInt(issue.getData()));
        stuff.setDt(DateUtils.getDate(new Date()));
        StuffService.insertStuff(stuff);

        Device device=DeviceService.getDeviceByDId(did);
        int yield=device.getInstallYield()+stuff.getNumAll();
        DeviceService.updateInstallYield(did,yield);
    }

    /**
     *更新超级密码
     * @param did
     * @param issue
     * @param result
     */
    public static void dealUpspwd(int did, Issue issue,String result){
        UpSpwd spwd=new UpSpwd();
        spwd.setdid(did);
        spwd.setspwd(issue.getData());
        spwd.setDt(DateUtils.getDateTime(new Date()));
        UpSpwdService.insertUpSpwd(spwd);
        DeviceService.updateSpwd(did,issue.getData());
    }


    /**
     *更新智盒版本
     * @param did
     * @param issue
     * @param result
     */
    public static void dealUpdateVer(int did, Issue issue,String result){
        Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
        if (null != hs && !"".equals(hs) && hs.size() > 0)
        {
            SocketChannel skt = hs.get(issue.getDid());
            if (null != skt && skt.isActive())
            {
                skt.close();
            }
            Constants.HM_SOCKET.remove(issue.getDid());
            Constants.HM_QUENEN_DEVICE.remove(issue.getDid());
        }
    }


}
