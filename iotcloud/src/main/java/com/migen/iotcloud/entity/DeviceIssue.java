package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 *
 */
public class DeviceIssue
{
	private int	   did;
	private String	didShow;
	private String	moduleId;
	private String	name;
	private String	address;
	private String	genCom;
	private String	useCom;
	private String	spwd;
	private int	   status;
	private int	   runStatus;
	private String	dt;
	private String	plcName;

	public String getPlcName()
	{
		return plcName;
	}

	public void setPlcName(String plcName)
	{
		this.plcName = plcName;
	}

	public int getRunStatus()
	{
		return runStatus;
	}

	public void setRunStatus(int runStatus)
	{
		this.runStatus = runStatus;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public String getDidShow()
	{
		return didShow;
	}

	public void setDidShow(String didShow)
	{
		this.didShow = didShow;
	}

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getGenCom()
	{
		return genCom;
	}

	public void setGenCom(String genCom)
	{
		this.genCom = genCom;
	}

	public String getUseCom()
	{
		return useCom;
	}

	public void setUseCom(String useCom)
	{
		this.useCom = useCom;
	}

	public String getSpwd()
	{
		return spwd;
	}

	public void setSpwd(String spwd)
	{
		this.spwd = spwd;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
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
	    return "DeviceBeanIssue [did=" + did + ", didShow=" + didShow + ", moduleId=" + moduleId + ", name=" + name
	            + ", address=" + address + ", genCom=" + genCom + ", useCom=" + useCom + ", spwd=" + spwd + ", status="
	            + status + ", runStatus=" + runStatus + ", dt=" + dt + ", plcName=" + plcName + "]";
    }

}
