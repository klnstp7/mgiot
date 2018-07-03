package com.migen.iotcloud.entity;

public class CompanyByCidMac
{
	private int	   cidmac;
	private String	commac;

	public int getCidmac()
	{
		return cidmac;
	}

	public void setCidmac(int cidmac)
	{
		this.cidmac = cidmac;
	}

	public String getCommac()
	{
		return commac;
	}

	public void setCommac(String commac)
	{
		this.commac = commac;
	}

	@Override
	public String toString()
	{
		return "CompanyBeanByCidMac [cidmac=" + cidmac + ", commac=" + commac + "]";
	}

}
