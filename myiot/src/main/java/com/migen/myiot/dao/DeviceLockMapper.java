package com.migen.myiot.dao;

import com.migen.myiot.entity.DeviceLock;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface DeviceLockMapper {

    int isExistDeviceLock(@Param("did") int did, @Param("ltype") String ltype);

    int insertDeviceLock(DeviceLock deviceLock);

    int deviceUnLock(DeviceLock deviceLock);

}
