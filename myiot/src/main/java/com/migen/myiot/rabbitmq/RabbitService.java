package com.migen.myiot.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.migen.myiot.utils.LogUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.migen.myiot.entity.Issue;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.netty.ChannelSession;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/8.
 */
public class RabbitService {

    static ConnectionFactory factory = (ConnectionFactory) SpringContext.getBean("rabbitMQ");

    /**
     * 发送消息
     * @param session
     */
    public  static void sendNettyMesssage(ChannelSession session)  {
        try{
            Connection connection= factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Constants.QUENCE_NAME_DEVICE, false, false, false, null);
            channel.basicPublish("", Constants.QUENCE_NAME_DEVICE, null, JSON.toJSONBytes(session));
            //LogUtil.info("send data to netty queue success,data:"+JSON.toJSONBytes(session));
            channel.close();
            connection.close();
        } catch (Exception ex) {
            LogUtil.error("send data to netty queue fail,data:"+JSON.toJSONBytes(session));
        }
    }

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
            //LogUtil.info("send data to issue queue success,data:"+ JSON.toJSONBytes(issue));
            channel.close();
            connection.close();
        } catch (Exception ex) {
            LogUtil.error("send data to issue queue fail,data:"+ JSON.toJSONBytes(issue));
        }
    }
}
