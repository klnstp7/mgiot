package com.migen.iotcloud.dao;

import com.migen.iotcloud.condition.DeviceCondition;
import com.migen.iotcloud.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface DeviceMapper {

    List<Device> getDevices();

   /* List<Device> getDeviceFirst2(int cid);*/

    int countByCond(DeviceCondition Cond);

    List<Device> selectByCond(DeviceCondition Cond);

    List<Device> getActiveDevice();

    Device getDeviceById(int did);

    Device getDeviceByModuleId(String moduleId);

    int updateDevice(Device device);

    int deleteDevice(int did);

    int isExistsModuleId(@Param("did") int did,@Param("moduleid") String moduleid);

    int updateModule(@Param("did") int did,@Param("moduleid") String moduleid);

    int updateStatus(@Param("did") int did, @Param("status") int status);

}
