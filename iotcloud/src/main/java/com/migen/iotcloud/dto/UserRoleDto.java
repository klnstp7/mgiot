package com.migen.iotcloud.dto;

/**
 * 接口返回的用户信息
 * Created by Administrator on 2017/2/17.
 */
public class UserRoleDto {

    private int	rid;

    private boolean	 ck;

    private String	rname;

    public int getRid()
    {
        return rid;
    }

    public void setRid(int rid)
    {
        this.rid = rid;
    }

    public boolean getCk()
    {
        return ck;
    }

    public void setCk(boolean ck)
    {
        this.ck = ck;
    }

    public String getRname()
    {
        return rname;
    }

    public void setRname(String rname)
    {
        this.rname = rname;
    }
}
