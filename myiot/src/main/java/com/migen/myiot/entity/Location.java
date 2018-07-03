package com.migen.myiot.entity;

/**
 * 
 * @author fengy
 * 
 */
public class Location
{
	private int	   lid;
	private int	   did;
	private String	didShow;
	private String	moduleId;
	private int	   ltype;
	private double	longitude;
	private double	latitude;
	private String	address;
	private String	dt;
	private String	country;
	private String	province;
	private String	city;
	private String	citycode;
	private String	adcode;
	private String	road;
	private String	street;
	private String	poi;
	private int	   wifinum;
	private String locBase;	

	public String getLocBase()
	{
		return locBase;
	}

	public void setLocBase(String locBase)
	{
		this.locBase = locBase;
	}

	public int getWifinum()
	{
		return wifinum;
	}

	public void setWifinum(int wifinum)
	{
		this.wifinum = wifinum;
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

	public String getCitycode()
	{
		return citycode;
	}

	public void setCitycode(String citycode)
	{
		this.citycode = citycode;
	}

	public String getAdcode()
	{
		return adcode;
	}

	public void setAdcode(String adcode)
	{
		this.adcode = adcode;
	}

	public String getRoad()
	{
		return road;
	}

	public void setRoad(String road)
	{
		this.road = road;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getPoi()
	{
		return poi;
	}

	public void setPoi(String poi)
	{
		this.poi = poi;
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

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public int getLtype()
	{
		return ltype;
	}

	public void setLtype(int ltype)
	{
		this.ltype = ltype;
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
	    return "LocationBean [lid=" + lid + ", did=" + did + ", didShow=" + didShow + ", moduleId=" + moduleId
	            + ", ltype=" + ltype + ", longitude=" + longitude + ", latitude=" + latitude + ", address=" + address
	            + ", dt=" + dt + ", country=" + country + ", province=" + province + ", city=" + city + ", citycode="
	            + citycode + ", adcode=" + adcode + ", road=" + road + ", street=" + street + ", poi=" + poi
	            + ", wifinum=" + wifinum + ", locBase=" + locBase + "]";
    }

}
