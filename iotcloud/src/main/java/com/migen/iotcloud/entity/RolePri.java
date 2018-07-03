package com.migen.iotcloud.entity;

import java.util.Date;

public class RolePri
{
	private int	rpid;
	private int	rid;
	private int	mid;
	private Date dt;

	public int getRpId()
	{
		return rpid;
	}

	public void setRpId(int rpid)
	{
		this.rpid = rpid;
	}

	public int getRid()
	{
		return rid;
	}

	public void setRid(int rid)
	{
		this.rid = rid;
	}

	public int getMid()
	{
		return mid;
	}

	public void setMid(int mid)
	{
		this.mid = mid;
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
