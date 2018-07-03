package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 *
 */
public class Production
{
	private int	   sdid;
	private int	   did;
	private int	   sid;
	private int	   total;
	private int	   lefts;
	private int	   thistime;
	private String	dt;

	// 当前印刷色数
	private String	curColor;
	// 模切开启
	private String	modelCut;
	// 当前计数
	private String	curCount;
	// 版长
	private String	boardLong;
	// 走纸速度
	private String	paperSpeed;
	// 刮墨速度
	private String	removeInkSpeed;
	// 回墨速度
	private String	returnInkSpeed;
	// 印刷速度
	private String	printSpeed;
	// 放卷当前卷径
	private String	relVolumeRadius;
	// 放卷卷心最大距离
	private String	relVolumeMaxDis;
	// 放卷离纸面当前距离
	private String	relVolumeCurDis;
	// 收卷当前卷径
	private String	colVolumeRadius;
	// 收卷卷心最大距离
	private String	colVolumeMaxDis;
	// 收卷离纸面当前距离
	private String	colVolumeCurDis;
	// 机械参数--牵引直径
	private String	machinePullDiam;
	// 机械参数--刮刀周长
	private String	machineKnifeCirc;
	// 机械参数--张力补偿
	private String	machinePullCompensate;
	// 丝印--第一色刀架移动距离
	private String	print1stKnifDis;
	// 丝印--丝网1抓标附加距离
	private String	attach1stDis;
	// 丝印--第二色刀架移动距离
	private String	print2rdKnifDis;
	// 丝印--丝网2抓标附加距离
	private String	attach2rdDis;
	// 丝印--第三色刀架移动距离
	private String	print3thKnifDis;
	// 丝印--丝网3抓标附加距离
	private String	attach3thDis;
	// 丝印--模切抓标附加距离
	private String	attachCutDis;

	public String getCurColor()
	{
		return curColor;
	}

	public void setCurColor(String curColor)
	{
		this.curColor = curColor;
	}

	public String getModelCut()
	{
		return modelCut;
	}

	public void setModelCut(String modelCut)
	{
		this.modelCut = modelCut;
	}

	public String getCurCount()
	{
		return curCount;
	}

	public void setCurCount(String curCount)
	{
		this.curCount = curCount;
	}

	public String getBoardLong()
	{
		return boardLong;
	}

	public void setBoardLong(String boardLong)
	{
		this.boardLong = boardLong;
	}

	public String getPaperSpeed()
	{
		return paperSpeed;
	}

	public void setPaperSpeed(String paperSpeed)
	{
		this.paperSpeed = paperSpeed;
	}

	public String getRemoveInkSpeed()
	{
		return removeInkSpeed;
	}

	public void setRemoveInkSpeed(String removeInkSpeed)
	{
		this.removeInkSpeed = removeInkSpeed;
	}

	public String getReturnInkSpeed()
	{
		return returnInkSpeed;
	}

	public void setReturnInkSpeed(String returnInkSpeed)
	{
		this.returnInkSpeed = returnInkSpeed;
	}

	public String getPrintSpeed()
	{
		return printSpeed;
	}

	public void setPrintSpeed(String printSpeed)
	{
		this.printSpeed = printSpeed;
	}

	public String getRelVolumeRadius()
	{
		return relVolumeRadius;
	}

	public void setRelVolumeRadius(String relVolumeRadius)
	{
		this.relVolumeRadius = relVolumeRadius;
	}

	public String getRelVolumeMaxDis()
	{
		return relVolumeMaxDis;
	}

	public void setRelVolumeMaxDis(String relVolumeMaxDis)
	{
		this.relVolumeMaxDis = relVolumeMaxDis;
	}

	public String getRelVolumeCurDis()
	{
		return relVolumeCurDis;
	}

	public void setRelVolumeCurDis(String relVolumeCurDis)
	{
		this.relVolumeCurDis = relVolumeCurDis;
	}

	public String getColVolumeRadius()
	{
		return colVolumeRadius;
	}

	public void setColVolumeRadius(String colVolumeRadius)
	{
		this.colVolumeRadius = colVolumeRadius;
	}

	public String getColVolumeMaxDis()
	{
		return colVolumeMaxDis;
	}

	public void setColVolumeMaxDis(String colVolumeMaxDis)
	{
		this.colVolumeMaxDis = colVolumeMaxDis;
	}

	public String getColVolumeCurDis()
	{
		return colVolumeCurDis;
	}

	public void setColVolumeCurDis(String colVolumeCurDis)
	{
		this.colVolumeCurDis = colVolumeCurDis;
	}

	public String getMachinePullDiam()
	{
		return machinePullDiam;
	}

	public void setMachinePullDiam(String machinePullDiam)
	{
		this.machinePullDiam = machinePullDiam;
	}

	public String getMachineKnifeCirc()
	{
		return machineKnifeCirc;
	}

	public void setMachineKnifeCirc(String machineKnifeCirc)
	{
		this.machineKnifeCirc = machineKnifeCirc;
	}

	public String getMachinePullCompensate()
	{
		return machinePullCompensate;
	}

	public void setMachinePullCompensate(String machinePullCompensate)
	{
		this.machinePullCompensate = machinePullCompensate;
	}

	public String getPrint1stKnifDis()
	{
		return print1stKnifDis;
	}

	public void setPrint1stKnifDis(String print1stKnifDis)
	{
		this.print1stKnifDis = print1stKnifDis;
	}

	public String getAttach1stDis()
	{
		return attach1stDis;
	}

	public void setAttach1stDis(String attach1stDis)
	{
		this.attach1stDis = attach1stDis;
	}

	public String getPrint2rdKnifDis()
	{
		return print2rdKnifDis;
	}

	public void setPrint2rdKnifDis(String print2rdKnifDis)
	{
		this.print2rdKnifDis = print2rdKnifDis;
	}

	public String getAttach2rdDis()
	{
		return attach2rdDis;
	}

	public void setAttach2rdDis(String attach2rdDis)
	{
		this.attach2rdDis = attach2rdDis;
	}

	public String getPrint3thKnifDis()
	{
		return print3thKnifDis;
	}

	public void setPrint3thKnifDis(String print3thKnifDis)
	{
		this.print3thKnifDis = print3thKnifDis;
	}

	public String getAttach3thDis()
	{
		return attach3thDis;
	}

	public void setAttach3thDis(String attach3thDis)
	{
		this.attach3thDis = attach3thDis;
	}

	public String getAttachCutDis()
	{
		return attachCutDis;
	}

	public void setAttachCutDis(String attachCutDis)
	{
		this.attachCutDis = attachCutDis;
	}

	public int getSdid()
	{
		return sdid;
	}

	public void setSdid(int sdid)
	{
		this.sdid = sdid;
	}

	public int getDid()
	{
		return did;
	}

	public void setDid(int did)
	{
		this.did = did;
	}

	public int getSid()
	{
		return sid;
	}

	public void setSid(int sid)
	{
		this.sid = sid;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getLefts()
	{
		return lefts;
	}

	public void setLefts(int lefts)
	{
		this.lefts = lefts;
	}

	public int getThistime()
	{
		return thistime;
	}

	public void setThistime(int thistime)
	{
		this.thistime = thistime;
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
	    return "StuffDetailBean [sdid=" + sdid + ", did=" + did + ", sid=" + sid + ", total=" + total + ", lefts="
	            + lefts + ", thistime=" + thistime + ", dt=" + dt + ", curColor=" + curColor + ", modelCut=" + modelCut
	            + ", curCount=" + curCount + ", boardLong=" + boardLong + ", paperSpeed=" + paperSpeed
	            + ", removeInkSpeed=" + removeInkSpeed + ", returnInkSpeed=" + returnInkSpeed + ", printSpeed="
	            + printSpeed + ", relVolumeRadius=" + relVolumeRadius + ", relVolumeMaxDis=" + relVolumeMaxDis
	            + ", relVolumeCurDis=" + relVolumeCurDis + ", colVolumeRadius=" + colVolumeRadius
	            + ", colVolumeMaxDis=" + colVolumeMaxDis + ", colVolumeCurDis=" + colVolumeCurDis
	            + ", machinePullDiam=" + machinePullDiam + ", machineKnifeCirc=" + machineKnifeCirc
	            + ", machinePullCompensate=" + machinePullCompensate + ", print1stKnifDis=" + print1stKnifDis
	            + ", attach1stDis=" + attach1stDis + ", print2rdKnifDis=" + print2rdKnifDis + ", attach2rdDis="
	            + attach2rdDis + ", print3thKnifDis=" + print3thKnifDis + ", attach3thDis=" + attach3thDis
	            + ", attachCutDis=" + attachCutDis + "]";
    }

}
