package com.migen.iotcloud.entity;

public class CompanyByCidPoi
{
	private int	   cidpoi;
	private String	compoi;

	public int getCidpoi()
	{
		return cidpoi;
	}

	public void setCidpoi(int cidpoi)
	{
		this.cidpoi = cidpoi;
	}

	public String getCompoi()
	{
		return compoi;
	}

	public void setCompoi(String compoi)
	{
		this.compoi = compoi;
	}

	@Override
	public String toString()
	{
		return "CompanyBeanByCidPoi [cidpoi=" + cidpoi + ", compoi=" + compoi + "]";
	}

}
