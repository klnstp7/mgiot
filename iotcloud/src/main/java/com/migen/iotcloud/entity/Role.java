package com.migen.iotcloud.entity;

import java.util.Date;

public class Role
{
	private int	rid;
	private String	rname;
	private int	cid;
	private Date dt;
	private String	company;

	public int getRid()
	{
		return rid;
	}

	public void setRid(int rid)
	{
		this.rid = rid;
	}

	public String getRname()
	{
		return rname;
	}

	public void setRname(String rname)
	{
		this.rname = rname;
	}

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}
}
