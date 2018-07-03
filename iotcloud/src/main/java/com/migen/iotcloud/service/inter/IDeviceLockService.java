package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.entity.DeviceLock;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 */
public interface IDeviceLockService {
    List<DeviceLock> getLockByDeviceId(int did);
}
