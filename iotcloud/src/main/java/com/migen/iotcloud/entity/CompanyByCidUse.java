package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class CompanyByCidUse
{
	private int	   ciduse;
	private String	comuse;

	public int getCiduse()
	{
		return ciduse;
	}

	public void setCiduse(int ciduse)
	{
		this.ciduse = ciduse;
	}

	public String getComuse()
	{
		return comuse;
	}

	public void setComuse(String comuse)
	{
		this.comuse = comuse;
	}

	@Override
	public String toString()
	{
		return "CompanyBeanByCidUse [ciduse=" + ciduse + ", comuse=" + comuse + "]";
	}

}
