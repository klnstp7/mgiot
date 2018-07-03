package com.migen.iotcloud.entity;

/**
 * 指令
 */
public class UpSpwd {

    private int swid;

    private int did;

    private String spwd;

    private String  dt;

    public int getswid()
    {
        return swid;
    }

    public void setswid(int swid)
    {
        this.swid = swid;
    }

    public int getdid()
    {
        return did;
    }

    public void setdid(int did)
    {
        this.did = did;
    }

    public String getspwd()
    {
        return spwd;
    }

    public void setspwd(String spwd)
    {
        this.spwd = spwd;
    }

    public String getDt()
    {
        return dt;
    }

    public void setDt(String dt)
    {
        this.dt = dt;
    }

}
