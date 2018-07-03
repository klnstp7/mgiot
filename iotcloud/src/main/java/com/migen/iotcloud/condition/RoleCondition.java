package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

import java.util.List;

/**
 * Created by Lthui on 2017/3/17.
 */
public class RoleCondition extends BaseRowBound {

    public RoleCondition() {

    }

    private String rname;

    private int cid;

    private List<Integer> cidList;

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
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
