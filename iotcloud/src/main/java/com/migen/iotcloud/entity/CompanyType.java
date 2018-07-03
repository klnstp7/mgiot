package com.migen.iotcloud.entity;

import java.util.Date;

/**
 * 
 * @author
 * 
 */
public class CompanyType
{
	private int	   ctid;
	private int	ctype;
	private String	ctname;
	private Date dt;

	public int getCtid()
	{
		return ctid;
	}

	public void setCtid(int ctid)
	{
		this.ctid = ctid;
	}

	public int getCtype()
	{
		return ctype;
	}
	public void setCtype(int ctype)
	{
		this.ctype = ctype;
	}
	public String getCtname()
	{
		return ctname;
	}

	public void setCtname(String ctname)
	{
		this.ctname = ctname;
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
