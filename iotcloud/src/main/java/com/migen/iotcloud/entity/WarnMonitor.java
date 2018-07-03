package com.migen.iotcloud.entity;

import java.util.Date;

/**
 *
 * @author fengy
 *
 */
public class WarnMonitor
{
	private String	company;
	private String	wtname;
	private String	didshow;
	private String	moduleid;
	private String	usecom;
	private Date	dt;
	private int	errpri;
	private String	strdt;

	public String getDidshow()
	{
		return didshow;
	}

	public void setDidshow(String didshow)
	{
		this.didshow = didshow;
	}

	public String getmoduleid()
	{
		return moduleid;
	}

	public void setmoduleid(String moduleid)
	{
		this.moduleid = moduleid;
	}

	public int getErrpri()
	{
		return errpri;
	}

	public void setErrpri(int errpri)
	{
		this.errpri = errpri;
	}

	public String getUsecom()
	{
		return usecom;
	}

	public void setUsecom(String usecom)
	{
		this.usecom = usecom;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getWtname()
	{
		return wtname;
	}

	public void setWtname(String wtname)
	{
		this.wtname = wtname;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public String getStrdt()
	{
		return strdt;
	}

	public void setStrdt(String strdt)
	{
		this.strdt = strdt;
	}

}
