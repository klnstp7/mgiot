package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class ConfigPLCType
{
	private String	pid;
	private String	PLCType;

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getPLCType()
	{
		return PLCType;
	}

	public void setPLCType(String pLCType)
	{
		PLCType = pLCType;
	}

	@Override
    public String toString()
    {
	    return "ConfigPLCTypeBean [pid=" + pid + ", PLCType=" + PLCType + "]";
    }

}
