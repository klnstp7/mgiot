package com.migen.iotcloud.dto;

import java.util.Date;

/**
 * 
 * @author fengy
 * 
 */
public class CompanyDto
{
	private int	   cid;
	private String	company;
	private String	poi;
	private int	   ctype;
	private String	   ctname;
	private int	   status;
	private String	address;
	private Date dt;
	private int	   usrid;
	private String	bcid;
	private Integer	   _parentId;
	private String parentname;

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

	public String getCtname()
	{
		return ctname;
	}

	public void setCtname(String ctname)
	{
		this.ctname = ctname;
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

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public Integer get_parentId()
	{
		return _parentId;
	}

	public void set_parentId(Integer _parentId)
	{
		this._parentId = _parentId;
	}

	public String getParentname()
	{
		return parentname;
	}

	public void setParentname(String parentname)
	{
		this.parentname = parentname;
	}

}
