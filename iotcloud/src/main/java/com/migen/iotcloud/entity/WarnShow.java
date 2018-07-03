package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class WarnShow
{
	private int	   wid;
	private int	   did;
	private String	info;
	private String	des;
	private String	dt;
	private int	   ismodify;
	private String	dtmodify;
	private String	fromthing;
	private String	errpri;
	private String	detail;

	private String	usecom;
	private String	company;

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

	public String getInfo()
	{
		return info;
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

	public String getDt()
	{
		return dt;
	}

	public void setDt(String dt)
	{
		this.dt = dt;
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

	public String getFromthing()
	{
		return fromthing;
	}

	public void setFromthing(String fromthing)
	{
		this.fromthing = fromthing;
	}

	public String getErrpri()
	{
		return errpri;
	}

	public void setErrpri(String errpri)
	{
		this.errpri = errpri;
	}

	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
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

	@Override
	public String toString()
	{
		return "WarnShowBean [wid=" + wid + ", did=" + did + ", info=" + info + ", des=" + des + ", dt=" + dt
		        + ", ismodify=" + ismodify + ", dtmodify=" + dtmodify + ", fromthing=" + fromthing + ", errpri="
		        + errpri + ", detail=" + detail + ", usecom=" + usecom + ", company=" + company + "]";
	}

}
