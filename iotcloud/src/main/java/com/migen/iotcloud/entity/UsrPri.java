package com.migen.iotcloud.entity;

/**
 * 权限功能涉及到的用户信息
 * 
 * @author fengy
 * 
 */
public class UsrPri
{
	private int	   upid;
	private int	   usrid;
	private String	uname;
	private String	dt;
	private int	   status;
	private int	   utype;
	private String	   priid;
	private int	   cid;

	public int getUpId()
	{
		return upid;
	}

	public void setUpId(int upid)
	{
		this.upid = upid;
	}
	
	public int getUtype()
	{
		return utype;
	}

	public void setUtype(int utype)
	{
		this.utype = utype;
	}

	public int getUsrid()
	{
		return usrid;
	}

	public void setUsrid(int usrid)
	{
		this.usrid = usrid;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getDt()
	{
		return dt;
	}

	public void setDt(String dt)
	{
		this.dt = dt;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getPriId()
	{
		return priid;
	}

	public void setPriId(String priid)
	{
		this.priid = priid;
	}

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

}
