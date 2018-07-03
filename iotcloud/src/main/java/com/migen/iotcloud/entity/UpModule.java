package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class UpModule
{
	private int	   moid;
	private int	   did;
	private String	oldmoduleid;
	private String	newmoduleid;
	private String	dt;

	public int getMoid()
	{
		return moid;
	}

	public void setMoid(int moid)
	{
		this.moid = moid;
	}

	public int geDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public String getoldmoduleid()
	{
		return oldmoduleid;
	}

	public void setoldmoduleid(String oldmoduleid)
	{
		this.oldmoduleid = oldmoduleid;
	}

	public String getnewmoduleid()
	{
		return newmoduleid;
	}

	public void setnewmoduleid(String newmoduleid)
	{
		this.newmoduleid = newmoduleid;
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
