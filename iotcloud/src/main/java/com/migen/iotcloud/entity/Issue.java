package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class Issue
{
	private int	   iid;
	private int	   did;
	private String	uname;
	private int	   flag;
	private String	dt;
	private String	itype;
	private String	des;
	private String	activeSeq;
    private String data;

	public Issue(){

	}

	public String getActiveSeq()
	{
		return activeSeq;
	}

	public void setActiveSeq(String activeSeq)
	{
		this.activeSeq = activeSeq;
	}

	public String getDes()
	{
		return des;
	}

	public void setDes(String des)
	{
		this.des = des;
	}

	public String getItype()
	{
		return itype;
	}

	public void setItype(String itype)
	{
		this.itype = itype;
	}

	public int getIid()
	{
		return iid;
	}

	public void setIid(int iid)
	{
		this.iid = iid;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String info)
	{
		this.uname = info;
	}

	public int getFlag()
	{
		return flag;
	}

	public void setFlag(int flag)
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

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "IssueBean [iid=" + iid + ", did=" + did + ", uname=" + uname + ", flag=" + flag + ", dt=" + dt
		        + ", itype=" + itype + ", des=" + des + ", activeSeq=" + activeSeq + "]";
	}

}
