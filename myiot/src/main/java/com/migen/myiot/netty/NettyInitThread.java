package com.migen.myiot.netty;

import com.migen.myiot.rabbitmq.RabbitService;
import com.migen.myiot.utils.LogUtil;
import com.migen.myiot.entity.Issue;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.Utils;

public  class NettyInitThread implements Runnable {

    int did;

    public NettyInitThread(int did){
        this.did=did;
    }

    public void run() {
        try{
            Issue issue = new Issue();
            issue.setDid(did);
            issue.setUname("system");
            issue.setItype(Constants.INNER_INSTALL_YIELD);
            issue.setDes("预设产量");
            String activeSeq = Utils.getRanFileName();
            issue.setActiveSeq(activeSeq);
            RabbitService.sendIssueMesssage(issue);

           /* Thread.sleep(10*1000);

            Issue locissue = new Issue();
            locissue.setDid(did);
            locissue.setUname("system");
            locissue.setItype(Constants.INNER_LOCATION);
            locissue.setDes("定位");
            activeSeq = Utils.getRanFileName();
            locissue.setActiveSeq(activeSeq);
            RabbitService.sendIssueMesssage(locissue);*/
        }catch (Exception ex){
            LogUtil.error("device init data fail,error message:"+ex.getMessage());
        }

    }

}
