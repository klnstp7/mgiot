package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class CompanyAddUser
{
	private int	   cid;
	private String	company;

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	@Override
    public String toString()
    {
	    return "CompanyBeanAddUser [cid=" + cid + ", company=" + company + "]";
    }

}
