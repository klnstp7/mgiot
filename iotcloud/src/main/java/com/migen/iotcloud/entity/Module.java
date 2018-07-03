package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 *
 */
public class Module
{
	private String	moduleID;
	private String	info;
	private String	dt;

	public String getModuleID()
	{
		return moduleID;
	}

	public void setModuleID(String moduleID)
	{
		this.moduleID = moduleID;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
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
	    return "ModuleBean [moduleID=" + moduleID + ", info=" + info + ", dt=" + dt + "]";
    }

}
