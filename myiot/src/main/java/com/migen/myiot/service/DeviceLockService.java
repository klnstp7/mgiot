package com.migen.myiot.service;

import com.migen.myiot.dao.DeviceLockMapper;
import com.migen.myiot.entity.DeviceLock;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */

public class DeviceLockService {

    static DeviceLockMapper deviceLockMapper= SpringContext.getSqlSession().getMapper(DeviceLockMapper.class);

    public static boolean isExistDeviceLock(int did, String ltype){
        return  deviceLockMapper.isExistDeviceLock(did,ltype)>0;
    }

    public  static int insertDeviceLock(DeviceLock deviceLock){
        return deviceLockMapper.insertDeviceLock(deviceLock);
    }

    public static int deviceUnLock(DeviceLock deviceLock){
        return deviceLockMapper.deviceUnLock(deviceLock);
    }

}
