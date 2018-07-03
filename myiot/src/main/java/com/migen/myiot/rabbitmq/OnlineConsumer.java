package com.migen.myiot.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.migen.myiot.service.DeviceService;
import com.migen.myiot.utils.LogUtil;
import com.rabbitmq.client.*;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.SpringContext;
import io.netty.channel.socket.SocketChannel;

import java.io.IOException;
import java.util.Map;

public  class OnlineConsumer extends Thread {

    public void run() {
        try{
            ConnectionFactory factory = (ConnectionFactory) SpringContext.getBean("rabbitMQ");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Constants.QUENCE_NAME_ONLINE, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] bytes)
                        throws IOException {

                    int did = JSON.parseObject(bytes, Integer.class);
                   // LogUtil.info("online queue received message,data:"+String);
                    try {
                        Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
                        SocketChannel skt = hs.get(did);
                        if (null == skt)
                        {
                            DeviceService.updateSocket(did,2,2);
                        }
                    }catch (Exception e){
                        LogUtil.error("online queue message dealed fail,error message:"+e.getMessage());
                    }
                }
            };
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(Constants.QUENCE_NAME_ONLINE, true, consumer);
        }catch ( Exception ex ){
            ex.printStackTrace();
            LogUtil.error("online server consumer start fail ,error message："+ex.getMessage());
        }
    }


}
