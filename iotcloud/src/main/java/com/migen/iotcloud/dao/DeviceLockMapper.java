package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.DeviceLock;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface DeviceLockMapper {

    List<DeviceLock>  getLockByDeviceId(int did);

    int deleteDeviceLock(@Param("did")int did);
}
