package com.migen.myiot.netty;

import com.alibaba.fastjson.JSON;
import com.migen.myiot.service.IssueService;
import com.migen.myiot.utils.LogUtil;
import com.migen.myiot.entity.Issue;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.DateUtils;

import java.util.Date;

public  class IssueConsumeThread implements Runnable {

    byte[] bytes;

    public IssueConsumeThread(byte[] bytes){
        this.bytes=bytes;
    }

    public void run() {
        Issue issue= JSON.parseObject(bytes,Issue.class);
        LogUtil.info("issue queue received message,data:"+ JSON.toJSONString(issue));
        try {
            //判断指令
            issue.setFlag(0);
            //插入Issue
            issue.setDt(DateUtils.getDateTime(new Date()));
            if(!issue.getItype().equals(Constants.INNER_DEVICE_DEL)){
                IssueService.insertIssue(issue);
            }
            if(issue.getItype().equals(Constants.INNER_LOCK_FORCE)) {//锁定
                IssueCommand.issueLock(issue);
            }else if(issue.getItype().equals(Constants.INNER_UNLOCK_DEVICE)){//解除锁定
                IssueCommand.issueUnLock(issue);
            }else if(issue.getItype().equals(Constants.INNER_LOCATION)){//定位
                IssueCommand.issuePosition(issue);
            }else if(issue.getItype().equals(Constants.INNER_INSTALL_YIELD)) {//预设产量
                IssueCommand.issueInstallYield(issue);
            }else if(issue.getItype().equals(Constants.INNER_REAL_YIELD)){//产量计数
                IssueCommand.issueRealYield(issue);
            }else if(issue.getItype().equals(Constants.INNER_DEVICE_DEL)){//删除设备
                IssueCommand.deleteDevice(issue.getDid());
            }else if(issue.getItype().equals(Constants.INNER_UPVER)){//升级智盒版本
                IssueCommand.issueUpdateVer(issue);
            }else if(issue.getItype().equals(Constants.INNER_ADDSTUFF)){//增加产量
                IssueCommand.issueAddNum(issue);
            }else if(issue.getItype().equals(Constants.INNER_UPSPWD)){//更新密码
                IssueCommand.issueSpwd(issue);
            }else if(issue.getItype().equals(Constants.INNER_SEND_COMMAND)){//发送指令
                IssueCommand.sendCommand(issue);
            }else if(issue.getItype().equals(Constants.INNER_SEND_HEARTBEAT)){//心跳
                IssueCommand.sendHeartBeat(issue);
            }else if(issue.getItype().equals(Constants.INNER_SEND_GPRS)){//主连接类型,地址和端口配置
                IssueCommand.sendGprs(issue);
            }
            //LogUtil.info("issue queue message dealed success");
        }catch (Exception e){
            LogUtil.error("issue queue message dealed fail,error message:"+e.getMessage());
        }
    }

}
