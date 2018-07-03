package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class ConfigVer
{
	private int	   cvid;
	private String	name;
	private String	plcname;
	private String	version;
	private String	uname;
	private String	url;
	private String	dt;
	private String	filename;

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public int getCvid()
	{
		return cvid;
	}

	public void setCvid(int cvid)
	{
		this.cvid = cvid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPlcname()
	{
		return plcname;
	}

	public void setPlcname(String plcname)
	{
		this.plcname = plcname;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
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
		return "ConfigVerBean [cvid=" + cvid + ", name=" + name + ", plcname=" + plcname + ", version=" + version
		        + ", uname=" + uname + ", url=" + url + ", dt=" + dt + ", filename=" + filename + "]";
	}

}
