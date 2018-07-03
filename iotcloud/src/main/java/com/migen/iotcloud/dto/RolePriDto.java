package com.migen.iotcloud.dto;

import java.util.Date;

public class RolePriDto
{
	private int	   mid;
	private String	mname;
	private String	url;
	private String	icon;
	private Integer	   parentid;
	private String	   pricode;
	private boolean visible;
	private int mtype;
	private int ordernum;
	private Date dt;
	private Integer	   _parentId;
	private boolean ck;

	public int getMtype()
	{
		return mtype;
	}

	public void setMtype(int mtype)
	{
		this.mtype = mtype;
	}

	public int getMid()
	{
		return mid;
	}

	public void setMid(int mid)
	{
		this.mid = mid;
	}

	public String getMname()
	{
		return mname;
	}

	public void setMname(String mname)
	{
		this.mname = mname;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}


	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getPriCode()
	{
		return pricode;
	}

	public void setPriCode(String pricode)
	{
		this.pricode = pricode;
	}

	public boolean getCk()
	{
		return ck;
	}

	public void setCk(boolean ck)
	{
		this.ck = ck;
	}

	public Integer getParentid()
	{
		return parentid;
	}

	public void setParentid(Integer parentid)
	{
		this.parentid = parentid;
	}

	public int getOrdernum()
	{
		return ordernum;
	}

	public void setOrdernum(int ordernum)
	{
		this.ordernum = ordernum;
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

	public boolean getVisible()
	{
		return visible;
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

}
