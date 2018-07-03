package com.migen.myiot.service;

import com.migen.myiot.dao.DeviceMapper;
import com.migen.myiot.entity.Device;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.SpringContext;
import com.migen.myiot.utils.Utils;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class DeviceService  {


    static DeviceMapper deviceMapper=SpringContext.getSqlSession().getMapper(DeviceMapper.class);

    public static Device getDeviceByDivShow(String didShow){

        return deviceMapper.getDeviceByDivShow(didShow);
    }

    public static Device getDeviceByModuleId(String moduleId){
        return deviceMapper.getDeviceByModuleId(moduleId);
    }

    public static Device getDeviceByDId(int did){
        Device device=deviceMapper.getDeviceByDId(did);
        return device;
    }

    public  static int insertDevice(Device device){
        int result= deviceMapper.insertDevice(device);
        return  result;
    }

    public  static int updateSocket(int did,int runStatus,int socket){
        int result= deviceMapper.updateSocket(did,runStatus,socket);
        return  result;
    }

    public static String genDidShow()
    {
        // 设备不存在就生成并插入到数据库
        String didOne = Utils.genRandom(Constants.LEN_ONE, Constants.NUMBERS);
        String didLast = Utils.genRandom(Constants.LEN_SEVEN, Constants.NUMBERZERO);
        String didShow = didOne + didLast;
        if (deviceMapper.getDeviceByDivShow(didShow)!=null)
        {
            genDidShow();
        }

        return didShow;
    }

    public static String genSPwd()
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

    public static int updateStatus(int did,int status){
        return deviceMapper.updateStatus(did,status);
    }

    public static int updateInstallYield( int did,  int installyield){
        return deviceMapper.updateInstallYield(did,installyield);
    }

    public static int updateRealYield( int did,  int realyield){
        return deviceMapper.updateRealYield(did,realyield);
    }

    public static int updateSpwd(int did, String spwd){
        return deviceMapper.updateSpwd(did,spwd);
    }
}
