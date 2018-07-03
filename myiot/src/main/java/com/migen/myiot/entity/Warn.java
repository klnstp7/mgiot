package com.migen.myiot.entity;

import java.util.Date;

/**
 * 
 * @author fengy
 * 
 */
public class Warn
{
	private int	   wid;
	private int	   did;
	private int	wtype;
	private String	wtname;
	private String	info;
	private String	des;
	private Date dt;
	private int	   ismail;
	private int	   ismodify;
	private String	dtmodify;
	private int	   fromthing;
	private int	   errpri;
	private String	detail;

	private int	ciduse;
	private String	company;
	private int	   ctype;
	private String	uname;
	private String	mail;
	private int	   utype;

	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public int getFromthing()
	{
		return fromthing;
	}

	public void setFromthing(int fromthing)
	{
		this.fromthing = fromthing;
	}

	public int getErrpri()
	{
		return errpri;
	}

	public void setErrpri(int errpri)
	{
		this.errpri = errpri;
	}

	public int getIemail()
	{
		return ismail;
	}

	public void setIsemail(int ismail)
	{
		this.ismail = ismail;
	}

	public int getIsmodify()
	{
		return ismodify;
	}

	public void setIsmodify(int ismodify)
	{
		this.ismodify = ismodify;
	}

	public String getDtmodify()
	{
		return dtmodify;
	}

	public void setDtmodify(String dtmodify)
	{
		this.dtmodify = dtmodify;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public int getCtype()
	{
		return ctype;
	}

	public void setCtype(int ctype)
	{
		this.ctype = ctype;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public int getUtype()
	{
		return utype;
	}

	public void setUtype(int utype)
	{
		this.utype = utype;
	}

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

	public int getWtype()
	{
		return wtype;
	}

	public void setWtype(int wtype)
	{
		this.wtype = wtype;
	}
	public String getWtname()
	{
		return wtname;
	}

	public void setWtname(String wtname)
	{
		this.wtname = wtname;
	}

	public String getInfo()
	{
		return wtname;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public String getDes()
	{
		return des;
	}

	public void setDes(String des)
	{
		this.des = des;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public int getCiduse()
	{
		return ciduse;
	}

	public void setCiduse(int ciduse)
	{
		this.ciduse = ciduse;
	}


}
