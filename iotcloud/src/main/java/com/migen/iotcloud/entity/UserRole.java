package com.migen.iotcloud.entity;

import java.util.Date;

public class UserRole
{
	private int	urid;
	private int	usrid;
	private int	rid;
	private Date dt;

	public int getUrid()
	{
		return urid;
	}

	public void setUrid(int urid)
	{
		this.urid = urid;
	}

	public int getUsrid()
	{
		return usrid;
	}

	public void setUsrid(int usrid)
	{
		this.usrid = usrid;
	}

	public int getRid()
	{
		return rid;
	}

	public void setRid(int rid)
	{
		this.rid = rid;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}
}
