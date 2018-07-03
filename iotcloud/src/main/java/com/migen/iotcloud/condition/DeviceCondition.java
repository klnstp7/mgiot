package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

/**
 * Created by Lthui on 2017/3/17.
 */
public class DeviceCondition extends BaseRowBound {

    public DeviceCondition(){

    }

    private String moduleId;

    private String didShow;

    private String useCom;

    private  int status;

    private int runStatus;

    private int cid;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getdidShow() {
        return didShow;
    }

    public void setdidShow(String didShow) {
        this.didShow = didShow ;
    }

    public String getuseCom() {
        return useCom;
    }

    public void setuseCom(String useCom) {
        this.useCom = useCom;
    }

    public int getstatus() {
        return status;
    }

    public void setstatus(int status) {
        this.status = status;
    }

    public int getrunStatus() {
        return runStatus;
    }

    public void setrunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
