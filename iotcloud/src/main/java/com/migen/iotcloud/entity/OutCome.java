package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class OutCome
{
	// 所属公司ccompany 所属设备device 开机时长worktime 开机效率 生产时长stuffdetail 生产效率
	// 生产数量stuffdetail 平均每件生产时间 废品数量 废品率
	private String	dateYMD;
	private int	   did;
	private String	usecom;
	private String	cids;
	private String	companys;
	private int	   openDuration;
	private String	openEfficiency;
	private int	   outDuration;
	private String	outEfficiency;
	private int	   outNum;
	private int	outTimeAvg;
	private int	   wasteNum;
	private String	wasteEfficiency;
	private String	dt;
	private String bcid;
	
	public String getBcid()
	{
		return bcid;
	}

	public void setBcid(String bcid)
	{
		this.bcid = bcid;
	}

	public String getOpenEfficiency()
	{
		return openEfficiency;
	}

	public void setOpenEfficiency(String openEfficiency)
	{
		this.openEfficiency = openEfficiency;
	}

	public String getOutEfficiency()
	{
		return outEfficiency;
	}

	public void setOutEfficiency(String outEfficiency)
	{
		this.outEfficiency = outEfficiency;
	}

	public int getOutTimeAvg()
	{
		return outTimeAvg;
	}

	public void setOutTimeAvg(int outTimeAvg)
	{
		this.outTimeAvg = outTimeAvg;
	}

	public String getWasteEfficiency()
	{
		return wasteEfficiency;
	}

	public void setWasteEfficiency(String wasteEfficiency)
	{
		this.wasteEfficiency = wasteEfficiency;
	}

	public String getDt()
	{
		return dt;
	}

	public void setDt(String dt)
	{
		this.dt = dt;
	}

	public String getDateYMD()
	{
		return dateYMD;
	}

	public void setDateYMD(String dateYMD)
	{
		this.dateYMD = dateYMD;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public String getUsecom()
	{
		return usecom;
	}

	public void setUsecom(String usecom)
	{
		this.usecom = usecom;
	}

	public String getCids()
	{
		return cids;
	}

	public void setCids(String cids)
	{
		this.cids = cids;
	}

	public String getCompanys()
	{
		return companys;
	}

	public void setCompanys(String companys)
	{
		this.companys = companys;
	}

	public int getOpenDuration()
	{
		return openDuration;
	}

	public void setOpenDuration(int openDuration)
	{
		this.openDuration = openDuration;
	}

	public int getOutDuration()
	{
		return outDuration;
	}

	public void setOutDuration(int outDuration)
	{
		this.outDuration = outDuration;
	}

	public int getOutNum()
	{
		return outNum;
	}

	public void setOutNum(int outNum)
	{
		this.outNum = outNum;
	}

	public int getWasteNum()
	{
		return wasteNum;
	}

	public void setWasteNum(int wasteNum)
	{
		this.wasteNum = wasteNum;
	}

	@Override
    public String toString()
    {
	    return "OutComeBean [dateYMD=" + dateYMD + ", did=" + did + ", usecom=" + usecom + ", cids=" + cids
	            + ", companys=" + companys + ", openDuration=" + openDuration + ", openEfficiency=" + openEfficiency
	            + ", outDuration=" + outDuration + ", outEfficiency=" + outEfficiency + ", outNum=" + outNum
	            + ", outTimeAvg=" + outTimeAvg + ", wasteNum=" + wasteNum + ", wasteEfficiency=" + wasteEfficiency
	            + ", dt=" + dt + ", bcid=" + bcid + "]";
    }

}
