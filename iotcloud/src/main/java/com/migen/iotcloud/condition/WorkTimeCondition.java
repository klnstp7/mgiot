package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

/**
 * Created by Lthui on 2017/3/17.
 */
public class WorkTimeCondition extends BaseRowBound {

    public WorkTimeCondition(){

    }

    private int did;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did ;
    }

}
