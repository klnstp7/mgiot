package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.dao.DeviceLockMapper;
import com.migen.iotcloud.entity.DeviceLock;
import com.migen.iotcloud.service.inter.IDeviceLockService;
import com.migen.iotcloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 */
@Service
public class DeviceLockService implements IDeviceLockService {

    @Autowired
    DeviceLockMapper deviceLockMapper;

   public List<DeviceLock> getLockByDeviceId(int did){
       List<DeviceLock> deviceLocks=deviceLockMapper.getLockByDeviceId(did);
       for(DeviceLock item:deviceLocks){
           item.setStrDt(DateUtils.getDateTime(item.getDt()));
       }
       return deviceLocks;
   }
}
