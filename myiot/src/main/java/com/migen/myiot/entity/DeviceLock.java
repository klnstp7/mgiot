package com.migen.myiot.entity;

public class DeviceLock
{
	private int	   dlid;
	private int	   did;
	private String	ltype;
	private int	   status;
	private String	dt;

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

	public String getDt()
	{
		return dt;
	}

	public void setDt(String dt)
	{
		this.dt = dt;
	}

	@Override
    public String toString()
    {
	    return "DeviceLockBean [dlid=" + dlid + ", did=" + did + ", ltype=" + ltype + ", status=" + status + ", dt="
	            + dt + "]";
    }

}
