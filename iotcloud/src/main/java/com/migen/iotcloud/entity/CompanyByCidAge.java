package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 *
 */
public class CompanyByCidAge
{
	private int	   cidage;
	private String	comage;

	public int getCidage()
	{
		return cidage;
	}

	public void setCidage(int cidage)
	{
		this.cidage = cidage;
	}

	public String getComage()
	{
		return comage;
	}

	public void setComage(String comage)
	{
		this.comage = comage;
	}

	@Override
    public String toString()
    {
	    return "CompanyBeanByCidAge [cidage=" + cidage + ", comage=" + comage + "]";
    }

}
