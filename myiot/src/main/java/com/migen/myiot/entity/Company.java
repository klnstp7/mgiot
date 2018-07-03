package com.migen.myiot.entity;

/**
 * 
 * @author fengy
 * 
 */
public class Company
{
	private int	   cid;
	private String	company;
	private String	poi;
	private int	   ctype;
	private int	   status;
	private String	address;
	private String	dt;
	private int	   usrid;
	private String	bcid;

	public String getBcid()
	{
		return bcid;
	}

	public void setBcid(String bcid)
	{
		this.bcid = bcid;
	}

	public int getUsrid()
	{
		return usrid;
	}

	public void setUsrid(int usrid)
	{
		this.usrid = usrid;
	}

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getPoi()
	{
		return poi;
	}

	public void setPoi(String poi)
	{
		this.poi = poi;
	}

	public int getCtype()
	{
		return ctype;
	}

	public void setCtype(int ctype)
	{
		this.ctype = ctype;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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
		return "CompanyBean [cid=" + cid + ", company=" + company + ", poi=" + poi + ", ctype=" + ctype + ", status="
		        + status + ", address=" + address + ", dt=" + dt + ", usrid=" + usrid + ", bcid=" + bcid + "]";
	}

}
