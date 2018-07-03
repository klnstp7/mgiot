package com.migen.iotcloud.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.migen.iotcloud.entity.Issue;
import com.migen.iotcloud.enums.Constants;
import com.migen.iotcloud.utils.LogUtil;
import com.migen.iotcloud.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/7.
 */
public class RabbitService {

    static ConnectionFactory factory = (ConnectionFactory) SpringContext.getBean("rabbitMQ");

    /**
     * 发送消息
     * @param issue
     */
    public static  void sendIssueMesssage( Issue issue)  {
        try{
            Connection connection= factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Constants.QUENCE_NAME_ISSUE, false, false, false, null);
            channel.basicPublish("", Constants.QUENCE_NAME_ISSUE, null, JSON.toJSONBytes(issue));
            LogUtil.info("send data to issue quence sucess,data:"+ JSON.toJSONBytes(issue));
            channel.close();
            connection.close();
        } catch (Exception ex) {
            LogUtil.info("send data to issue quence fail,d:"+ JSON.toJSONBytes(issue));
        }
    }
}
