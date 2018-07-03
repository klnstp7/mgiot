package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.condition.DeviceCondition;

import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.entity.Device;
import com.migen.iotcloud.entity.FirstMachine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IDeviceService {

     List<FirstMachine> realFirstNew(UserInfo ub, String condition);

     Map<String, Map<String, List<FirstMachine>>> dealList(UserInfo ub, String condition);

     LinkedHashMap<String, LinkedHashMap<String, List<FirstMachine>>> sortInfos(UserInfo ub, String condition);

     PageVo<Device> findByPaging(DeviceCondition condition, int page, int rows);

     List<Device> getActiveDevice();

     Device getDeviceById(int did);

     int updateDevice(Device device);

     void deleteDevice(int did,UserInfo user);

     String issueLock(int did,UserInfo user);

     String issueUnLock(int did,UserInfo user);

     void updateVer(int did,UserInfo user);

    void saveNums(int did, int addNum, UserInfo user);

     String saveModule(int did, String moduleid,UserInfo user);

     void issuespwd(int did,UserInfo user);

     void sendCommand(String moduleid,String command,UserInfo user);

    void sendHeartBeat(String moduleid,String heatbeat,UserInfo user);

    void sendGprs(String moduleid,String gprs,UserInfo user);
}
