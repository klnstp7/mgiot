package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class HeartTest
{
	private int	   htid;
	private int	   did;
	private int	   status;
	private String	flag;
	private String	dt;

	public int getHtid()
	{
		return htid;
	}

	public void setHtid(int htid)
	{
		this.htid = htid;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
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
	    return "HeartTestBean [htid=" + htid + ", did=" + did + ", status=" + status + ", flag=" + flag + ", dt=" + dt
	            + "]";
    }

}
