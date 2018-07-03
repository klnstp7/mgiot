package com.migen.iotcloud.entity;

import java.util.Date;

public class DeviceLock
{
	private int	   dlid;
	private int	   did;
	private String	ltype;
	private int	   status;
	private Date dt;
	private String strDt;

	public int getDlid()
	{
		return dlid;
	}

	public void setDlid(int dlid)
	{
		this.dlid = dlid;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public String getLtype()
	{
		return ltype;
	}

	public void setLtype(String ltype)
	{
		this.ltype = ltype;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public String getStrDt()
	{
		return strDt;
	}

	public void setStrDt(String strDt)
	{
		this.strDt = strDt;
	}

	@Override
    public String toString()
    {
	    return "DeviceLockBean [dlid=" + dlid + ", did=" + did + ", ltype=" + ltype + ", status=" + status + ", dt="
	            + dt + "]";
    }

}
