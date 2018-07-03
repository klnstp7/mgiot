package com.migen.iotcloud.entity;

import java.util.List;

/**
 * 
 * @author fengy
 * 
 */
public class FirstMachine
{
	// private String country;
	private int	               did;
	private String	           province;
	private String	           city;
	private String	           machineName;
	private String	           machineStatus;
	private String	           linkStatus;
	private List<WarnShow>	warnList;

	public List<WarnShow> getWarnList()
	{
		return warnList;
	}

	public void setWarnList(List<WarnShow> warnList)
	{
		this.warnList = warnList;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getMachineName()
	{
		return machineName;
	}

	public void setMachineName(String machineName)
	{
		this.machineName = machineName;
	}

	public String getMachineStatus()
	{
		return machineStatus;
	}

	public void setMachineStatus(String machineStatus)
	{
		this.machineStatus = machineStatus;
	}

	public String getLinkStatus()
	{
		return linkStatus;
	}

	public void setLinkStatus(String linkStatus)
	{
		this.linkStatus = linkStatus;
	}

	@Override
	public String toString()
	{
		return "FirstMachineBean [did=" + did + ", province=" + province + ", city=" + city + ", machineName="
		        + machineName + ", machineStatus=" + machineStatus + ", linkStatus=" + linkStatus + ", warnList="
		        + warnList + "]";
	}

}
