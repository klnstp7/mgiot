package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class ConfigMachineType
{
	private String	mid;
	private String	machineType;

	public String getMid()
	{
		return mid;
	}

	public void setMid(String mid)
	{
		this.mid = mid;
	}

	public String getMachineType()
	{
		return machineType;
	}

	public void setMachineType(String machineType)
	{
		this.machineType = machineType;
	}

	@Override
	public String toString()
	{
		return "ConfigMachineTypeBean [mid=" + mid + ", machineType=" + machineType + "]";
	}

}
