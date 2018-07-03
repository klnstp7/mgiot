package com.migen.iotcloud.entity;

import java.util.Date;

/**
 * 
 * @author fengy
 * 
 */
public class LocationRight
{
	private int	   lid;
	private int	   did;
	private String	didShow;
	private double	longitude;
	private double	latitude;
	private String	country;
	private String	province;
	private String	city;
	private String	address;
	private int	   status;
	private Date dt;
	private String strDt;

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
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

	public int getLid()
	{
		return lid;
	}

	public void setLid(int lid)
	{
		this.lid = lid;
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

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Date getDt()
	{
		return dt;
	}

	public void setDt(Date dt)
	{
		this.dt = dt;
	}

	public String getStrDt()
	{
		return strDt;
	}

	public void setStrDt(String strDt)
	{
		this.strDt = strDt;
	}

}
