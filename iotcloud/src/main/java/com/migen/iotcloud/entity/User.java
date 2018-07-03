package com.migen.iotcloud.entity;

import java.util.Date;

/**
 * 用户信息表
 * 
 * @author fengy
 * 
 */
public class User
{
	private int	   usrid;
	private String	uname;
	private String	pwd;
	private String	company;
	private int	   utype;
	private int	   status;
	private int	   cid;
	private Date dt;
	private int	   ctype;	 // 所属公司类型
	private String	mail;

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public int getCtype()
	{
		return ctype;
	}

	public void setCtype(int ctype)
	{
		this.ctype = ctype;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public int getUsrid()
	{
		return usrid;
	}

	public void setUsrid(int usrid)
	{
		this.usrid = usrid;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public int getUtype()
	{
		return utype;
	}

	public void setUtype(int utype)
	{
		this.utype = utype;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}
}
