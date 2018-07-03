package com.migen.myiot.netty;

import com.migen.myiot.entity.Issue;

/**
 * Created by Administrator on 2018/6/5.
 */
public class ChannelSession {

    private int did;

    private String operateType;

    private Issue issue;

    private String data;

    public int getDid()
    {
        return did;
    }

    public void setDid(int did)
    {
        this.did = did;
    }

    public String getOperateType()
    {
        return operateType;
    }

    public void setOperateType(String operateType)
    {
        this.operateType = operateType;
    }

    public Issue getIssue()
    {
        return issue;
    }

    public void setIssue(Issue issue)
    {
        this.issue = issue;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

}
