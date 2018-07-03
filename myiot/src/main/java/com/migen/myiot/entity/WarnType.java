package com.migen.myiot.entity;

import java.util.Date;

/**
 * 
 * @author fengy
 * 
 */
public class WarnType
{
	private int	   wtid;
	private int	   wtype;
	private String	wtname;
	private String dt;

	public int getWtid()
	{
		return wtid;
	}

	public void setWtid(int wtid)
	{
		this.wtid = wtid;
	}

	public int getWtype()
	{
		return wtype;
	}

	public void setWtype(int wtype)
	{
		this.wtype = wtype;
	}

	public String getWtname()
	{
		return wtname;
	}

	public void setWtname(String wtname)
	{
		this.wtname = wtname;
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
