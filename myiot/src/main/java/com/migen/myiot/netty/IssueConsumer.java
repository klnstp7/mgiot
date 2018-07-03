package com.migen.myiot.netty;

import com.migen.myiot.utils.LogUtil;
import com.rabbitmq.client.*;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.SpringContext;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class IssueConsumer extends Thread {

    ExecutorService executorService = Executors.newFixedThreadPool(100);

    public void run() {
        try{
            ConnectionFactory factory = (ConnectionFactory) SpringContext.getBean("rabbitMQ");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Constants.QUENCE_NAME_ISSUE, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] bytes)
                        throws IOException {
                    IssueConsumeThread issueConsumeThread =new IssueConsumeThread(bytes);
                    executorService.execute(issueConsumeThread);

                }
            };
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(Constants.QUENCE_NAME_ISSUE, true, consumer);
        }catch ( Exception ex ){
            ex.printStackTrace();
            LogUtil.error("issue server consumer start fail ,error message："+ex.getMessage());
        }
    }


}
