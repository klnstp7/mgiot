package com.migen.myiot.entity;

import java.util.HashMap;

/**
 * 
 * @author fengy
 * 
 */
public class SocketBack
{
	private String	                oneType;	// 与机器通信的唯一类型
	private String	                didShow;	// 对应didShow
	private String	                moduleId;	// 模块Id
	private String	                oneResult; // 对应SUC/FAIL
	// private JSONObject jbBack = new JSONObject(); // 封装其它单独的字段
	private HashMap<String, String>	hm;	   // 封装其它单独的字段
	private HashMap<String, String>	hmMul;	   // 封装其它单独的字段，以便多次下发时使用
	private String time;//原样带回

	
	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public HashMap<String, String> getHmMul()
	{
		return hmMul;
	}

	public void setHmMul(HashMap<String, String> hmMul)
	{
		this.hmMul = hmMul;
	}

	public String getDidShow()
	{
		return didShow;
	}

	public void setDidShow(String machineId)
	{
		this.didShow = machineId;
	}

	public String getOneResult()
	{
		return oneResult;
	}

	public void setOneResult(String oneResult)
	{
		this.oneResult = oneResult;
	}

	public String getOneType()
	{
		return oneType;
	}

	public void setOneType(String oneType)
	{
		this.oneType = oneType;
	}

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public HashMap<String, String> getHm()
	{
		return hm;
	}

	public void setHm(HashMap<String, String> hm)
	{
		this.hm = hm;
	}

	@Override
    public String toString()
    {
	    return "SocketBackBean [oneType=" + oneType + ", didShow=" + didShow + ", moduleId=" + moduleId
	            + ", oneResult=" + oneResult + ", hm=" + hm + ", hmMul=" + hmMul + ", time=" + time + "]";
    }

}
