package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.condition.DeviceCondition;
import com.migen.iotcloud.dao.*;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.entity.*;
import com.migen.iotcloud.enums.Constants;
import com.migen.iotcloud.init.MapperConfig;
import com.migen.iotcloud.rabbitmq.RabbitService;
import com.migen.iotcloud.service.inter.IDeviceService;
import com.migen.iotcloud.utils.ChangeUtils;
import com.migen.iotcloud.utils.StringUtil;
import com.migen.iotcloud.utils.Utils;
import com.migen.iotcloud.service.inter.IWarnService;
import com.migen.iotcloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class DeviceService implements IDeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Autowired
    IWarnService warnService;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    UpModuleMapper upModuleMapper;

    @Autowired
    LocationRightMapper locationRightMapper;

    @Autowired
    WorkTimeMapper workTimeMapper;

    @Autowired
    UpSpwdMapper upSpwdMapper;

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    DeviceLockMapper deviceLockMapper;

    public List<FirstMachine> realFirstNew(UserInfo ub, String condition){
        List<FirstMachine> result = new ArrayList<FirstMachine>();
        HashMap<Integer, FirstMachine> hmA = new HashMap<Integer, FirstMachine>();

        List<Device> devices=devices=deviceMapper.getDevices();;
       /* if(Constants.USR_SUPER == ub.getUtype()){
            devices=deviceMapper.getDevices();
        }else{
            devices=deviceMapper.getDeviceFirst2(ub.getCid());
        }*/

        for (Device item: devices) {
            FirstMachine td = new FirstMachine();
            td.setDid(item.getDid());
            td.setProvince(item.getProvince());
            td.setCity(item.getCity());
            td.setMachineName(item.getUseCom());
            if (item.getRunStatus() != 1)
            {
                td.setMachineStatus(ChangeUtils.deviceRunStatus(item.getRunStatus()));
            } else {
                td.setMachineStatus(ChangeUtils.deviceStatus(item.getStatus()));
            }
            td.setLinkStatus(ChangeUtils.deviceSocket(item.getSocket()));

            List<WarnShow> wList =warnService.queryWarnFirst(item.getDid());
            td.setWarnList(wList);

            if (!StringUtil.isNullOrEmpty(condition))
            {
                if (td.getProvince().contains(condition) || td.getCity().contains(condition)
                        || td.getMachineName().contains(condition))
                {
                    hmA.put(item.getDid(), td);
                }
            }
            else
            {
                hmA.put(item.getDid(), td);
            }
        }

        Set<Integer> keys = hmA.keySet();
        Iterator<Integer> itr = keys.iterator();
        while(itr.hasNext())
        {
            int key = itr.next();
            result.add(MapperConfig.map( hmA.get(key),FirstMachine.class));
        }
        return result;
    }

    /**
     *
     * @param ub
     * @param condition
     * @return
     */
    public  Map<String, Map<String, List<FirstMachine>>> dealList(UserInfo ub, String condition)
    {
        Map<String, Map<String, List<FirstMachine>>> hmProvince = new HashMap<String, Map<String, List<FirstMachine>>>();

        List<FirstMachine> listSrc = realFirstNew(ub,condition);
        for (int i = 0; i < listSrc.size(); i++)
        {
            FirstMachine fmBean = listSrc.get(i);
            String provice = fmBean.getProvince();
            String city = fmBean.getCity();

            Map<String, List<FirstMachine>> mapPro = hmProvince.get(provice);
            if (null == mapPro || mapPro.size() <= 0)
            {
                Map<String, List<FirstMachine>> hmCity = new HashMap<String, List<FirstMachine>>();
                List<FirstMachine> beanList = new ArrayList<FirstMachine>();
                beanList.add(fmBean);
                hmCity.put(city, beanList);
                hmProvince.put(provice, hmCity);
            }
            else
            {
                List<FirstMachine> listBean = mapPro.get(city);
                if (null == listBean || listBean.size() <= 0)
                {
                    List<FirstMachine> beanList = new ArrayList<FirstMachine>();
                    beanList.add(fmBean);
                    mapPro.put(city, beanList);
                }
                else
                {
                    listBean.add(fmBean);
                    mapPro.put(city, listBean);
                    hmProvince.put(provice, mapPro);
                }
            }
        }
        return hmProvince;
    }

    /**
     *
     * @param ub
     * @param condition
     * @return
     */
    public  LinkedHashMap<String, LinkedHashMap<String, List<FirstMachine>>> sortInfos(UserInfo ub, String condition)
    {
        Map<String, Map<String, List<FirstMachine>>> hmProvince = dealList(ub,condition);

        List<Map.Entry<String, Map<String, List<FirstMachine>>>> proListSortOK = new ArrayList<Map.Entry<String, Map<String, List<FirstMachine>>>>(
                hmProvince.entrySet());

        Collections.sort(proListSortOK, new Comparator<Map.Entry<String, Map<String, List<FirstMachine>>>>()
        {
            public int compare(Map.Entry<String, Map<String, List<FirstMachine>>> o1,
                               Map.Entry<String, Map<String, List<FirstMachine>>> o2)
            {
                return (o2.getValue().size()) - (o1.getValue().size());
            }
        });

        LinkedHashMap<String, LinkedHashMap<String, List<FirstMachine>>> proAll = new LinkedHashMap<String, LinkedHashMap<String, List<FirstMachine>>>();
        for (int k = 0; k < proListSortOK.size(); k++)
        {
            String keyProOk = proListSortOK.get(k).getKey();
            Map<String, List<FirstMachine>> hmCityValue = proListSortOK.get(k).getValue();
            List<Map.Entry<String, List<FirstMachine>>> cityListSortOK = new ArrayList<Map.Entry<String, List<FirstMachine>>>(
                    hmCityValue.entrySet());

            Collections.sort(cityListSortOK, new Comparator<Map.Entry<String, List<FirstMachine>>>()
            {
                public int compare(Map.Entry<String, List<FirstMachine>> c1,
                                   Map.Entry<String, List<FirstMachine>> c2)
                {
                    return (c2.getValue().size()) - (c1.getValue().size());
                }
            });

            LinkedHashMap<String, List<FirstMachine>> cityAll = new LinkedHashMap<String, List<FirstMachine>>();
            for (int m = 0; m < cityListSortOK.size(); m++)
            {
                Map.Entry<String, List<FirstMachine>> hmCityT = cityListSortOK.get(m);
                if (null != hmCityT)
                {
                    String cityKeyOk = hmCityT.getKey();
                    cityAll.put(cityKeyOk, hmCityT.getValue());
                }
            }
            proAll.put(keyProOk, cityAll);
        }

        return proAll;
    }


    /**
     * 查询
     * @param condition
     * @return
     */
    public PageVo<Device> findByPaging(DeviceCondition condition, int page, int rows){
        //计算记录数
        int total=deviceMapper.countByCond(condition);
        PageVo<Device> pageVo=new PageVo<Device>(total);
        condition.setStart((page-1)*rows);
        condition.setLimit(page * rows);
        List<Device> devices=deviceMapper.selectByCond(condition);
        //公司信息
        List<Company> companies=companyMapper.getAll();
        HashMap<Integer, String> hmCom = new HashMap<Integer, String>();
        for (Company item:companies) {
            hmCom.put(item.getCid(),item.getCompany());
        }

        for (Device item: devices) {
            boolean flagMul =StringUtil.isMul(item.getCids());
            if (flagMul)
            {
                item.setMul(2);
            }
            else
            {
                item.setMul(1);
            }
            item.setComser(hmCom.get(item.getCidser()));
            item.setComuse(hmCom.get(item.getCiduse()));
            item.setCommac(hmCom.get(item.getCidmac()));
            item.setComage(hmCom.get(item.getCidage()));
            item.setCompoi(hmCom.get(item.getCidpoi()));
        }
        pageVo.setRows(devices);
        return pageVo;
    }

   public List<Device> getActiveDevice(){
       return deviceMapper.getActiveDevice();
   }

   public Device  getDeviceById(int did){
       return  deviceMapper.getDeviceById(did);
   }

   public int updateDevice(Device device){
       return deviceMapper.updateDevice(device);
   }

   public void deleteDevice(int did,UserInfo user){
       upSpwdMapper.deleteUpSpwd(did);
       locationRightMapper.deleteLocationRight(did);
       workTimeMapper.deleteWorkTime(did);
       issueMapper.deleteIssue(did);
       deviceLockMapper.deleteDeviceLock(did);
       deviceMapper.deleteDevice(did);

       Issue issue = new Issue();
       issue.setDid(did);
       issue.setUname(user.getUname());
       issue.setItype(Constants.INNER_DEVICE_DEL);
       issue.setDes("删除设备");
       String activeSeq = Utils.getRanFileName();
       issue.setActiveSeq(activeSeq);
       RabbitService.sendIssueMesssage(issue);
   }

   public String issueLock(int did,UserInfo user){
       Device device=deviceMapper.getDeviceById(did);
       if(device.getStatus()!=Constants.DEVICE_UNLOCK){
           return "不能锁定机器！";
       }
       deviceMapper.updateStatus(did,Constants.DEVICE_LOCKING);
       Issue issue = new Issue();
       issue.setDid(did);
       issue.setUname(user.getUname());
       issue.setItype(Constants.INNER_LOCK_FORCE);
       issue.setDes("Lock");
       String activeSeq = Utils.getRanFileName();
       issue.setActiveSeq(activeSeq);
       RabbitService.sendIssueMesssage(issue);
       return Constants.SUC;
   }

    public String issueUnLock(int did,UserInfo user){
        Device device=deviceMapper.getDeviceById(did);
        if(device.getStatus()!=Constants.DEVICE_LOCK){
            return "不能解除锁定！";
        }
        deviceMapper.updateStatus(did,Constants.DEVICE_UNLOCKING);
        Issue issue = new Issue();
        issue.setDid(did);
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_UNLOCK_DEVICE);
        issue.setDes("unLock");
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        RabbitService.sendIssueMesssage(issue);
        return Constants.SUC;
    }


    public void updateVer(int did,UserInfo user){
        Issue issue = new Issue();
        issue.setDid(did);
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_UPVER);
        issue.setDes("UpdateVersion");
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        RabbitService.sendIssueMesssage(issue);
    }

    public void saveNums(int did,int addNum,UserInfo user){
        Issue issue = new Issue();
        issue.setDid(did);
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_ADDSTUFF);
        issue.setDes("增加产量");
        issue.setData(String.format("%d", addNum));
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        RabbitService.sendIssueMesssage(issue);
    }

    public String saveModule(int did, String moduleid,UserInfo user){
        if(deviceMapper.isExistsModuleId(did,moduleid)>0){
            return "新智盒编码已使用，请重新输入";
        }

        Device device=deviceMapper.getDeviceById(did);
        UpModule upModule=new UpModule();
        upModule.setDid(did);
        upModule.setoldmoduleid(device.getModuleId());
        upModule.setnewmoduleid(moduleid);
        upModule.setDt(DateUtils.getDateTime(new Date()));
        upModuleMapper.insertUpModule(upModule);
        deviceMapper.updateModule(did,moduleid);
        return Constants.SUC;
    }

    public void issuespwd(int did,UserInfo user){
        Issue issue = new Issue();
        issue.setDid(did);
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_UPSPWD);
        issue.setDes("更新超级密码");
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        issue.setData(genSPwd());
        RabbitService.sendIssueMesssage(issue);
    }

    public String genSPwd()
    {
        String pwd=null;
        boolean tmp=false;
        while(!tmp){
            String pwdOne = Utils.genRandom(Constants.LEN_ONE, Constants.NUMBERS_SPWD);
            String pwdLast = Utils.genRandom(Constants.LEN_SPWD, Constants.NUMBERZERO);
            pwd = pwdOne + pwdLast;
            if(Integer.parseInt(pwd)<=Short.MAX_VALUE){
                tmp=true;
            }
        }
        // 返回超级密码，写回客户端
        if (Utils.emptyStr(pwd))
        {
            pwd = Constants.SPWD_DEFAULT;
        }
        return pwd;
    }

    public void sendCommand(String moduleid,String command,UserInfo user){
        Device device=deviceMapper.getDeviceByModuleId(moduleid);
        if(device==null){
            return ;
        }
        Issue issue = new Issue();
        issue.setDid(device.getDid());
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_SEND_COMMAND);
        issue.setDes("Command");
        issue.setData(command);
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        RabbitService.sendIssueMesssage(issue);
    }



    public void sendHeartBeat(String moduleid,String heatbeat,UserInfo user){
        Device device=deviceMapper.getDeviceByModuleId(moduleid);
        if(device==null){
            return ;
        }
        Issue issue = new Issue();
        issue.setDid(device.getDid());
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_SEND_HEARTBEAT);
        issue.setDes("heartbeat");
        issue.setData(heatbeat);
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        RabbitService.sendIssueMesssage(issue);
    }

    public void sendGprs(String moduleid,String gprs,UserInfo user){
        Device device=deviceMapper.getDeviceByModuleId(moduleid);
        if(device==null){
            return ;
        }
        Issue issue = new Issue();
        issue.setDid(device.getDid());
        issue.setUname(user.getUname());
        issue.setItype(Constants.INNER_SEND_GPRS);
        issue.setDes("gprs");
        issue.setData(gprs);
        String activeSeq = Utils.getRanFileName();
        issue.setActiveSeq(activeSeq);
        RabbitService.sendIssueMesssage(issue);
    }
}
