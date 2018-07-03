package com.migen.myiot.entity;

public class Stuff
{
	private int	   sid;
	private int	   did;
	// 当前生产材料的所有需求
	private int	   numAll;
	private int	   status;
	private String	dt;
	// 剩余生产的量
	private int	   numRetain;

	public int getNumRetain()
	{
		return numRetain;
	}

	public void setNumRetain(int numRetain)
	{
		this.numRetain = numRetain;
	}

	public int getSid()
	{
		return sid;
	}

	public void setSid(int sid)
	{
		this.sid = sid;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public int getNumAll()
	{
		return numAll;
	}

	public void setNumAll(int numAll)
	{
		this.numAll = numAll;
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
	    return "StuffBean [sid=" + sid + ", did=" + did + ", numAll=" + numAll + ", status=" + status + ", dt=" + dt
	            + ", numRetain=" + numRetain + "]";
    }

}
