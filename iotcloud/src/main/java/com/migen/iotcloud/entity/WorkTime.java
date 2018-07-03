package com.migen.iotcloud.entity;

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
	private Date	dt;

	private String strStartTime;
	private String	strEndTime;
	private String	strDt;

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

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}


	public String getStrStartTime()
	{
		return strStartTime;
	}

	public void setStrStartTime(String strStartTime)
	{
		this.strStartTime = strStartTime;
	}

	public String getStrEndTime()
	{
		return strEndTime;
	}

	public void setStrEndTime(String strEndTime)
	{
		this.strEndTime = strEndTime;
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
	    return "WorkTimeBean [wid=" + wid + ", did=" + did + ", startTime=" + startTime + ", endTime=" + endTime
	            + ", dts=" + dts + ", status=" + status + ", dt=" + dt
	            + "]";
    }

}
