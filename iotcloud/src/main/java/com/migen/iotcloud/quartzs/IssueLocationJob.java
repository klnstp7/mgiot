package com.migen.iotcloud.quartzs;

import com.alibaba.fastjson.JSON;
import com.migen.iotcloud.entity.Device;
import com.migen.iotcloud.utils.Utils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.migen.iotcloud.entity.Issue;
import com.migen.iotcloud.enums.Constants;
import com.migen.iotcloud.service.impl.DeviceService;
import com.migen.iotcloud.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 定位
 */
public class IssueLocationJob {

    boolean islock=false;

    @Autowired
    ConnectionFactory factory;

    @Autowired
    DeviceService deviceService;

    public void execute() throws Exception {
        if(!islock) {
            islock = true;
            //发送定位消息
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            try {
                channel.queueDeclare(Constants.QUENCE_NAME_ISSUE, false, false, false, null);

                List<Device> deviceList = deviceService.getActiveDevice();
                for (Device device : deviceList) {
                    Issue issue = new Issue();
                    issue.setDid(device.getDid());
                    issue.setUname("system");
                    issue.setItype(Constants.INNER_LOCATION);
                    issue.setDes("定位");
                    String activeSeq = Utils.getRanFileName();
                    issue.setActiveSeq(activeSeq);
                    channel.basicPublish("", Constants.QUENCE_NAME_ISSUE, null, JSON.toJSONBytes(issue));
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