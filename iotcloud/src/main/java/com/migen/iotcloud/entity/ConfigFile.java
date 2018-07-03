package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class ConfigFile
{
	private int	   cfid;
	private String	name;
	private String	plcname;
	private String	filename;
	private String	version;
	private String	uname;
	private String	url;
	private String	dt;

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public int getCfid()
	{
		return cfid;
	}

	public void setCfid(int cfid)
	{
		this.cfid = cfid;
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

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
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
		return "ConfigFileBean [cfid=" + cfid + ", name=" + name + ", plcname=" + plcname + ", filename=" + filename
		        + ", version=" + version + ", uname=" + uname + ", url=" + url + ", dt=" + dt + "]";
	}

}
