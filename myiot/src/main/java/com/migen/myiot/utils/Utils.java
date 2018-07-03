package com.migen.myiot.utils;

import java.net.Socket;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import com.migen.myiot.entity.Issue;
import com.migen.myiot.entity.SocketBack;
import com.migen.myiot.enums.Constants;
import net.sf.json.JSONObject;

public class Utils
{

	/**
	 * 随机生成超级密码
	 *
	 * @return
	 */
	public static String genRandom(int len, char[] chars)
	{
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < len)
		{
			i = Math.abs(r.nextInt(chars.length));
			if (i >= 0 && i < chars.length)
			{
				pwd.append(chars[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	/**
	 * 空判断
	 *
	 * @param str
	 * @return
	 */
	public static boolean emptyStr(String str)
	{
		boolean flag = true;
		if (null != str && !"".equals(str))
		{
			flag = false;
		}
		return flag;
	}

	/**
	 *
	 * @param socketed
	 * @return
	 */
	public static boolean isClosedSocke(Socket socketed)
	{
		boolean flag = true;
		// 处于连接状态
		if (null != socketed && !socketed.isClosed() && socketed.isConnected())
		{
			flag = false;
		}
		return flag;
	}

	/**
	 *
	 * @param did
	 * @return
	 */
	public static boolean isExistDid(int did)
	{
		return did > 0 ? true : false;
	}

	/**
	 *
	 * @param d
	 * @return
	 */
	private static double rad(double d)
	{
		return d * Math.PI / 180.0;
	}

	/**
	 * 返回 米
	 *
	 * @param long1
	 * @param lat1
	 * @param long2
	 * @param lat2
	 * @return
	 */
	public static double getDistance(double long1, double lat1, double long2, double lat2)
	{
		double a, b, d, sa2, sb2;
		lat1 = rad(lat1);
		lat2 = rad(lat2);
		a = lat1 - lat2;
		b = rad(long1 - long2);

		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * Constants.EARTH_RADIUS * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d * 1000;
	}

	/**
	 *
	 * @param strs
	 * @return
	 */
	public static String[] splitStr(String strs)
	{
		String[] rt = null;
		if (!emptyStr(strs))
		{
			rt = strs.split("\\,");
		}

		return rt;
	}

	/**
	 *
	 * @param str
	 * @return
	 */
	public static boolean isSocketStrEnd(String str)
	{
		if (str.contains("}"))
		{
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param dle
	 * @return
	 */
	public static boolean isScopeLock(double dle)
	{
		return dle > Constants.EARTH_DIS ? true : false;
	}

	/**
	 *
	 * @param innerType
	 * @return
	 */
	public static String innerToOuter(String innerType)
	{
		String outer = "";
		if (Constants.INNER_LOCK_LOCATION.equals(innerType))
		{
			outer = Constants.OUTER_SUB_LOCK_LOCATION;
		}
		else if (Constants.INNER_LOCK_POI.equals(innerType))
		{
			outer = Constants.OUTER_SUB_LOCK_POI;
		}
		else if (Constants.INNER_LOCK_NUM.equals(innerType))
		{
			outer = Constants.OUTER_SUB_LOCK_NUMS;
		}
		else if (Constants.INNER_LOCK_FORCE.equals(innerType))
		{
			outer = Constants.OUTER_SUB_LOCK_FORCE;
		}
		else if (Constants.INNER_ADDSTUFF.equals(innerType))
		{
			outer = Constants.OUTER_STUFF;
		}
		else if (Constants.INNER_UPSPWD.equals(innerType))
		{
			outer = Constants.OUTER_SPWD;
		}
		else if (Constants.INNER_UPMODULE.equals(innerType))
		{
			outer = Constants.OUTER_MODULE;
		}
		else if (Constants.INNER_UNLOCK_DEVICE.equals(innerType))
		{
			outer = Constants.OUTER_SUB_UNLOCK_FORCE;
		}
		else if (Constants.INNER_HEART_TEST.equals(innerType))
		{
			outer = Constants.OUTER_HEART_BEAT;
		}
		else if (Constants.INNER_CONFIGFILE.equals(innerType))
		{
			outer = Constants.OUTER_CONFIGFILE;
		}
		else if (Constants.INNER_START.equals(innerType))
		{
			outer = Constants.OUTER_START;
		}
		else if (Constants.INNER_RESTART.equals(innerType))
		{
			outer = Constants.OUTER_RESTART;
		}
		return outer;
	}

	/**
	 *
	 * @param sbb
	 * @return
	 */
	public static HashMap<String, String> getBackHm(SocketBack sbb)
	{
		HashMap<String, String> hm = sbb.getHm();

		if (null == hm || "".equals(hm))
		{
			hm = new HashMap<String, String>();
		}

		return hm;
	}

	/**
	 *
	 * @param sbb
	 * @return
	 */
	public static HashMap<String, String> getBackHmMul(SocketBack sbb)
	{
		HashMap<String, String> hm = sbb.getHmMul();

		if (null == hm || "".equals(hm))
		{
			hm = new HashMap<String, String>();
		}

		return hm;
	}

	/**
	 *
	 * @param sbb
	 * @return
	 */
	public static HashMap<String, String> getMulHm(SocketBack sbb)
	{
		HashMap<String, String> hm = sbb.getHmMul();

		if (null == hm || "".equals(hm))
		{
			hm = new HashMap<String, String>();
		}

		return hm;
	}

	/**
	 *
	 * @param joClient
	 * @return
	 */
	public static boolean isBackMsg(JSONObject joClient)
	{
		if (joClient.containsKey("oneResult"))
		{
			return true;
		}

		return false;
	}



	/**
	 *
	 * @return
	 */
	public static String getRanNum()
	{
		String rt = "";
		rt = DateUtils.getDateTimeYMDHMS(new Date());
		Random rd = new Random(System.currentTimeMillis());
		rt = rt + rd.nextInt(10000);

		return rt;
	}

	/**
	 *
	 * @param classStr
	 * @param methodStr
	 * @param msg
	 */
	public static void logSys(String msg)
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String dt = DateUtils.getDateTime(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append(dt).append("==>");
		sb.append(stackTrace[2].getClassName()).append("-");
		sb.append(stackTrace[2].getMethodName()).append("-");
		sb.append(stackTrace[2].getLineNumber()).append(" : ");
		sb.append(msg);
		System.out.println(sb.toString());
		/*
		 * for(StackTraceElement s : stackTrace){ System.out.println("类名：" +
		 * s.getClassName() + "  ,  java文件名：" + s.getFileName() + ",  当前方法名字：" +
		 * s.getMethodName() + "" + " , 当前代码是第几行：" + s.getLineNumber() + ", " );
		 * }
		 */
	}

	/**
	 *
	 * @param initValue
	 * @param lastValue
	 * @return
	 */
	public static int getIntFromStr(int initValue, String lastValue)
	{
		int rt = initValue;
		try
		{
			rt = Integer.parseInt(lastValue);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rt;
	}

	/**
	 *
	 * @param oldVer
	 * @param newVer
	 * @return
	 */
	public static boolean compareVersion(String oldVer, String newVer)
	{
		boolean flag = false;
		if (!Utils.emptyStr(newVer))
		{
			if (Utils.emptyStr(oldVer))
			{
				flag = true;
			}
			else
			{
				String[] olds = oldVer.split("\\.");
				String[] news = newVer.split("\\.");
				if (olds.length != 2 && news.length == 2)
				{
					flag = true;
				}
				else if (olds.length == 2 && news.length == 2)
				{
					int olds0 = Utils.getIntFromStr(0, olds[0]);
					int news0 = Utils.getIntFromStr(0, news[0]);
					if (news0 > olds0)
					{
						flag = true;
					}
					else if (news0 == olds0)
					{
						int olds1 = Utils.getIntFromStr(0, olds[1]);
						int news1 = Utils.getIntFromStr(0, news[1]);
						if (news1 > olds1)
						{
							flag = true;
						}
					}
				}
			}
		}

		return flag;
	}

	/**
	 *
	 * @param beforeTime
	 * @return
	 */
	public static boolean isReSend(long beforeTime)
	{
		boolean flag = false;
		long second = 1 * 60 * 1000;
		long curTime = new Date().getTime();
		long dis = curTime - beforeTime;

		long rt = dis / second;
		if (rt >= 2)
		{
			flag = true;
		}

		return flag;
	}

	/**
	 *
	 * @param beforeTime
	 * @return
	 */
	public static boolean isReSendOut(long beforeTime)
	{
		boolean flag = false;
		long second = 30 * 1000;
		long curTime = new Date().getTime();
		long dis = curTime - beforeTime;

		long rt = dis / second;
		if (rt >= 10)
		{
			flag = true;
		}

		return flag;
	}

	/**
	 *
	 * @param ibnNew
	 */
	public static void delSameHm(Issue ibnNew)
	{
		Map<String, Issue> hm = Constants.HM_ISSUE;
		// Set<String> set = hm.keySet();
		Collection<Issue> cc = hm.values();
		Iterator<Issue> iter = cc.iterator();
		while (iter.hasNext())
		{
			Issue ibnOld = iter.next();
			if (ibnNew.getDid() == ibnOld.getDid() && ibnNew.getItype().equals(ibnOld.getItype()))
			{
				Constants.HM_ISSUE.remove(ibnOld.getActiveSeq());
				break;
			}
		}
	}

	/**
	 *
	 * @param did
	 */
	public static void clearDb(int did)
	{
		/*ComDb.delDevice(did);
		ComDb.delHeart(did);
		ComDb.delLocation(did);
		ComDb.delMachineDetail(did);*/
	}

	/**
	 *
	 * @param subType
	 * @return
	 */
	public static boolean dealWarnActiveType(String subType)
	{
		boolean flag = false;
		if (Constants.OUTER_SUB_WARN_NUMS.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_POI.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_TROUBLE.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_LOCK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_CLOSE.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_OTHER.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_CHANGEID.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_BATTERY.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_CONNCLOSE.equals(subType))
		{
			flag = true;
		}

		return flag;
	}

	/**
	 *
	 * @param subType
	 * @return
	 */
	public static boolean dealWarnSolveType(String subType)
	{
		boolean flag = false;
		if (Constants.OUTER_SUB_WARN_NUMS_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_POI_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_TROUBLE_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_LOCK_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_CLOSE_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_OTHER_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_CHANGEID_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_BATTERY_OK.equals(subType))
		{
			flag = true;
		}
		else if (Constants.OUTER_SUB_WARN_CONNCLOSE_OK.equals(subType))
		{
			flag = true;
		}

		return flag;
	}

	/**
	 *
	 * @param time
	 * @return
	 */
	public static String getClientTime(String time)
	{
		if (Utils.emptyStr(time))
		{
			time = DateUtils.getDateTime(new Date());
		}

		return time;
	}

	/**
	 *
	 * @param str
	 * @return
	 */
	public static String getStr(String str)
	{
		if (null == str)
		{
			str = "";
		}
		return str;
	}

	/**
	 *
	 * @param str
	 * @return
	 */
	public static String getStrDelComma(String str)
	{
		str = str.substring(0, str.length() - 1);
		return str;
	}

	/**
	 * 判断是否数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}


	/**
	 * 计算两个经纬度的距离(单位:米)
	 * @param userLat 维度1
	 * @param userLng 经度1
	 * @param venueLat 维度2
	 * @param venueLng 经度2
	 * @return
	 */
	public static int calDistanceInMeter(double userLat, double userLng, double venueLat, double venueLng) {

		double latDistance = Math.toRadians(userLat - venueLat);
		double lngDistance = Math.toRadians(userLng - venueLng);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
				* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))*1000;
		return (int) Math.round(6371 * c);
	}

	/**
	 *
	 * @return
	 */
	public static String getRanFileName()
	{
		String rt = "";
		rt = DateUtils.getDateTimeYMDHMS(new Date());
		Random rd = new Random(System.currentTimeMillis());
		rt = rt + rd.nextInt(10000);

		return rt;
	}
}
