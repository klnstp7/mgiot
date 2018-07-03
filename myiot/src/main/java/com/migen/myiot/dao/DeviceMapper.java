package com.migen.myiot.dao;

import com.migen.myiot.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface DeviceMapper {

    List<Device> loadDevices();

    Device getDeviceByDId(int did);

    Device getDeviceByModuleId(String moduleId);

    Device getDeviceByDivShow(String didShow);

    int insertDevice(Device device);

    int updateSocket(@Param("did") int did,@Param("runStatus") int runStatus, @Param("socket") int socket);

    int updateStatus(@Param("did") int did, @Param("status") int status);

    int updateInstallYield(@Param("did") int did, @Param("installyield") int installyield);

    int updateRealYield(@Param("did") int did, @Param("realyield") int realyield);

    int updateSpwd(@Param("did") int did, @Param("spwd") String spwd);
}
