package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class DeviceLoation
{
	private int	   lid;
	private int	   did;
	private String	didshow;
	private String	moduleid;
	private int	   ltype;
	private double	longitude;
	private double	latitude;
	private String	address;
	private int	   status;
	private String	dt;
	private int	   wifinum;
	private String	locBase;

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

	public String getDidshow()
	{
		return didshow;
	}

	public void setDidshow(String didshow)
	{
		this.didshow = didshow;
	}

	public String getModuleid()
	{
		return moduleid;
	}

	public void setModuleid(String moduleid)
	{
		this.moduleid = moduleid;
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
		return "DeviceLoationBean [lid=" + lid + ", did=" + did + ", didshow=" + didshow + ", moduleid=" + moduleid
		        + ", ltype=" + ltype + ", longitude=" + longitude + ", latitude=" + latitude + ", address=" + address
		        + ", status=" + status + ", dt=" + dt + ", wifinum=" + wifinum + ", lotBase=" + locBase + "]";
	}

}
