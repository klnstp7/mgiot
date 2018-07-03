package com.migen.myiot.init;

import com.migen.myiot.netty.NettyServer;
import com.migen.myiot.netty.NettyServerConsumer;
import com.migen.myiot.netty.IssueConsumer;
import com.migen.myiot.rabbitmq.OnlineConsumer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/5.
 */
@Component
public class RefreshEvent implements ApplicationListener<ContextRefreshedEvent>  {

    NettyServer nettyTServer;

    NettyServerConsumer nettyServerConsumer;

    IssueConsumer issueConsumer;

    OnlineConsumer onlineConsumer;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            //Netty Server
            if (null == nettyTServer)
            {
                nettyTServer = new NettyServer();
                nettyTServer.start();
            }else{
                nettyTServer.interrupt();
            }

            //Rabbit
             if (null == issueConsumer)
            {
                issueConsumer = new IssueConsumer();
                issueConsumer.start();
            }else{
                  issueConsumer.interrupt();
            }


           if (null == nettyServerConsumer)
            {
                nettyServerConsumer = new NettyServerConsumer();
                nettyServerConsumer.start();
            }else{
                nettyServerConsumer.interrupt();
            }

            if (null == onlineConsumer)
            {
                onlineConsumer = new OnlineConsumer();
                onlineConsumer.start();
            }else{
                onlineConsumer.interrupt();
            }
        }
    }
}
