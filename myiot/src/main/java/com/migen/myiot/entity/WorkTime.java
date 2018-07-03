package com.migen.myiot.entity;

import java.util.Date;

/**
 * 
 * @author fengy
 * 
 */
public class WorkTime
{
	private int	   wid;
	private int	   did;
	private Date startTime;
	private Date	endTime;
	private int	dts;
	private int	   status;
	private String	dt;


	public int getWid()
	{
		return wid;
	}

	public void setWid(int wid)
	{
		this.wid = wid;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public int getDts()
	{
		return dts;
	}

	public void setDts(int dts)
	{
		this.dts = dts;
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
	    return "WorkTimeBean [wid=" + wid + ", did=" + did + ", startTime=" + startTime + ", endTime=" + endTime
	            + ", dts=" + dts + ", status=" + status + ", dt=" + dt
	            + "]";
    }

}
