package com.migen.myiot.entity;

import java.io.Serializable;

public class Device implements Serializable
{
	private int	   did;
	private String	didShow;
	private String	moduleId;
	private String	name;
	private String	address;
	private String	genCom;
	private String	useCom;
	private String	spwd;
	private int	   status;
	private int	   runStatus;
	private String	dt;
	private String	plcName;
	private String	company;
	private String	companys;
	private int	   cid;
	private String	cids;
	private int	   configStatus;
	private int	   pwdvalid;
	private String	version;
	private String	url;
	private int	   mul;	     // 只有企业本身为1，多个为2
	private String	isUp;	     // 1up，2no; 升级
	private int	   udtype;
	private int	   socket;

	private int	   cidser;
	private int	   cidmac;
	private int	   cidage;
	private int	   ciduse;
	private int	   cidpoi;

	private String	comser;
	private String	commac;
	private String	comage;
	private String	comuse;
	private String	compoi;

	private String	province;
	private String	city;

	private int installyield;

	private int realyield;

	public String getComser()
	{
		return comser;
	}

	public void setComser(String comser)
	{
		this.comser = comser;
	}

	public String getCommac()
	{
		return commac;
	}

	public void setCommac(String commac)
	{
		this.commac = commac;
	}

	public String getComage()
	{
		return comage;
	}

	public void setComage(String comage)
	{
		this.comage = comage;
	}

	public String getComuse()
	{
		return comuse;
	}

	public void setComuse(String comuse)
	{
		this.comuse = comuse;
	}

	public String getCompoi()
	{
		return compoi;
	}

	public void setCompoi(String compoi)
	{
		this.compoi = compoi;
	}

	public int getCidser()
	{
		return cidser;
	}

	public void setCidser(int cidser)
	{
		this.cidser = cidser;
	}

	public int getCidmac()
	{
		return cidmac;
	}

	public void setCidmac(int cidmac)
	{
		this.cidmac = cidmac;
	}

	public int getCidage()
	{
		return cidage;
	}

	public void setCidage(int cidage)
	{
		this.cidage = cidage;
	}

	public int getCiduse()
	{
		return ciduse;
	}

	public void setCiduse(int ciduse)
	{
		this.ciduse = ciduse;
	}

	public int getCidpoi()
	{
		return cidpoi;
	}

	public void setCidpoi(int cidpoi)
	{
		this.cidpoi = cidpoi;
	}

	public int getSocket()
	{
		return socket;
	}

	public void setSocket(int socket)
	{
		this.socket = socket;
	}

	public int getUdtype()
	{
		return udtype;
	}

	public void setUdtype(int udtype)
	{
		this.udtype = udtype;
	}

	public int getMul()
	{
		return mul;
	}

	public void setMul(int mul)
	{
		this.mul = mul;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getIsUp()
	{
		return isUp;
	}

	public void setIsUp(String isUp)
	{
		this.isUp = isUp;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public int getPwdvalid()
	{
		return pwdvalid;
	}

	public void setPwdvalid(int pwdvalid)
	{
		this.pwdvalid = pwdvalid;
	}

	public int getConfigStatus()
	{
		return configStatus;
	}

	public void setConfigStatus(int configStatus)
	{
		this.configStatus = configStatus;
	}

	public String getCompanys()
	{
		return companys;
	}

	public void setCompanys(String companys)
	{
		this.companys = companys;
	}

	public String getCids()
	{
		return cids;
	}

	public void setCids(String cids)
	{
		this.cids = cids;
	}

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

	public String getPlcName()
	{
		return plcName;
	}

	public void setPlcName(String plcName)
	{
		this.plcName = plcName;
	}

	public int getRunStatus()
	{
		return runStatus;
	}

	public void setRunStatus(int runStatus)
	{
		this.runStatus = runStatus;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getGenCom()
	{
		return genCom;
	}

	public void setGenCom(String genCom)
	{
		this.genCom = genCom;
	}

	public String getUseCom()
	{
		return useCom;
	}

	public void setUseCom(String useCom)
	{
		this.useCom = useCom;
	}

	public String getSpwd()
	{
		return spwd;
	}

	public void setSpwd(String spwd)
	{
		this.spwd = spwd;
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

	public int getInstallYield()
	{
		return installyield;
	}

	public void setInstallYield(int installyield)
	{
		this.installyield = installyield;
	}

	public int getRealYield()
	{
		return realyield;
	}

	public void setRealYield(int realyield)
	{
		this.realyield = realyield;
	}

	@Override
	public String toString()
	{
		return "DeviceBean [did=" + did + ", didShow=" + didShow + ", moduleId=" + moduleId + ", name=" + name
				+ ", address=" + address + ", genCom=" + genCom + ", useCom=" + useCom + ", spwd=" + spwd + ", status="
				+ status + ", runStatus=" + runStatus + ", dt=" + dt + ", plcName=" + plcName + ", pwdvalid="
				+ pwdvalid + ", configstatus=" + configStatus + ", version=" + version + ", socket=" + socket
				+ ", cids=" + cids + ", cidmac=" + cidmac + ", cidage=" + cidage + ", ciduse=" + ciduse + ", cidpoi="
				+ cidpoi + "]";
	}
}

