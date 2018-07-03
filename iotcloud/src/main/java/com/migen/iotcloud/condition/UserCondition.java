package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

import java.util.List;

/**
 * Created by Lthui on 2017/3/17.
 */
public class UserCondition extends BaseRowBound {

    public UserCondition() {

    }

    private String uname;

    private int status;

    private int cid;

    private List<Integer> cidList;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public List<Integer> getCidList() {
        return cidList;
    }

    public void setCidList( List<Integer> cidList) {
        this.cidList = cidList;
    }
}
