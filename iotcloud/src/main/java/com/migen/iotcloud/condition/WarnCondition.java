package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

/**
 * Created by Lthui on 2017/3/17.
 */
public class WarnCondition extends BaseRowBound {

    public WarnCondition(){

    }

    private String scompany;

    private String device;

    private String  startTime;

    private String  endTime;

    public String getScompany() {
        return scompany;
    }

    public void setScompany(String scompany) {
        this.scompany = scompany ;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime ;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime ;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device ;
    }
}
