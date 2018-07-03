package com.migen.iotcloud.quartzs;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.migen.iotcloud.entity.Device;
import com.migen.iotcloud.enums.Constants;
import com.migen.iotcloud.service.impl.DeviceService;
import com.migen.iotcloud.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 检查设备在线
 */
public class CheckOnlineJob {

    boolean islock=false;

    @Autowired
    ConnectionFactory factory;

    @Autowired
    DeviceService deviceService;

    public void execute() throws Exception {
        if(!islock) {
            islock = true;
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            try {
                channel.queueDeclare(Constants.QUENCE_NAME_ONLINE, false, false, false, null);

                List<Device> deviceList = deviceService.getActiveDevice();
                String activeSeq = null;
                for (Device device : deviceList) {
                    channel.basicPublish("", Constants.QUENCE_NAME_ONLINE, null, JSON.toJSONBytes(device.getDid()));
                }
            } catch (Exception ex) {
                LogUtil.error("定时发送消息失败，错误消息：" + ex.getMessage());
            } finally {
                channel.close();
                connection.close();
                islock = false;
            }

        }
    }
}