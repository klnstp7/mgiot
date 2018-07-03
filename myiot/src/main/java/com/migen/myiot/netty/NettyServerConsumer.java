package com.migen.myiot.netty;

import com.alibaba.fastjson.JSON;
import com.migen.myiot.service.DealMessageService;
import com.migen.myiot.service.IssueService;
import com.migen.myiot.utils.LogUtil;
import com.rabbitmq.client.*;
import com.migen.myiot.entity.Issue;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.SpringContext;

import java.io.IOException;

public  class NettyServerConsumer extends Thread {

    public void run() {
        try{
            ConnectionFactory factory = (ConnectionFactory) SpringContext.getBean("rabbitMQ");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Constants.QUENCE_NAME_DEVICE, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] bytes)
                        throws IOException {

                    ChannelSession session = JSON.parseObject(bytes, ChannelSession.class);
                    LogUtil.info("netty queue received message,data:"+ JSON.toJSONString(session));
                    int did=session.getDid();
                    String operateType=session.getOperateType();
                    Issue issue=session.getIssue();
                    if(did==0) return;
                    try {
                        //判断指令

                        if (operateType.equals(Constants.OUTER_LOCK)){//锁定机器
                            DealMessageService.dealLock(did,issue, session.getData());
                        }else  if (operateType.equals(Constants.OUTER_UNLOCK)){//解除锁定
                            DealMessageService.dealUnLock(did,issue, session.getData());
                        }else if (operateType.equals(Constants.OUTER_LOCATION)) {//定位
                            DealMessageService.dealPotision(did, session.getData());
                        }else if(operateType.equals(Constants.OUTER_INSTALL_YIELD)){//预设产量
                            DealMessageService.dealInstallYield(did,issue, session.getData());
                        }else if(operateType.equals(Constants.OUTER_REAL_YIELD)){//产量计数
                            DealMessageService.dealRealYield(did,issue, session.getData());
                        }else if(operateType.equals(Constants.OUTER_STUFF)){//增加产量
                            DealMessageService.dealAddNum(did,issue, session.getData());
                        }else if(operateType.equals(Constants.OUTER_SPWD)){//修改密码
                            DealMessageService.dealUpspwd(did,issue, session.getData());
                        }else if(operateType.equals(Constants.OUTER_UP_VERSION)){//更新智盒版本
                            DealMessageService.dealUpdateVer(did,issue, session.getData());
                        }
                        //处理Issue
                        issue.setFlag(1);
                        IssueService.updateIssue(issue);
                       // LogUtil.info("netty queue message dealed success");
                    }catch (Exception e){
                        LogUtil.error("netty queue message dealed fail,error message:"+e.getMessage());
                    }
                }
            };
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(Constants.QUENCE_NAME_DEVICE, true, consumer);
        }catch ( Exception ex ){
            ex.printStackTrace();
            LogUtil.error("netty server consumer start fail ,error message："+ex.getMessage());
        }
    }


}
