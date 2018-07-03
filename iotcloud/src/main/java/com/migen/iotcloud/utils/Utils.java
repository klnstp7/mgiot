package com.migen.iotcloud.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.migen.iotcloud.enums.Constants;
import net.sf.json.JSONObject;

/**
 * 
 * @author fengy
 * 
 */
public class Utils
{
	private static String	rtLast	 = "";

	private static String	pathFile	= "";
	private static String	pathVer	 = "";

	private static String	SEARCON	 = "";

	public static String getSEARCON()
	{
		return SEARCON;
	}

	public static void setSEARCON(String sEARCON)
	{
		SEARCON = sEARCON;
	}

	public static String getPathFile()
	{
		return pathFile;
	}

	public static void setPathFile(String pathFile)
	{
		Utils.pathFile = pathFile;
	}

	public static String getPathVer()
	{
		return pathVer;
	}

	public static void setPathVer(String pathVer)
	{
		Utils.pathVer = pathVer;
	}

	public static String getRtLast()
	{
		return rtLast;
	}

	public static void setRtLast(String rtLast)
	{
		Utils.rtLast = rtLast;
	}

	public static void setLast(int flag)
	{
		if (flag == 1)
		{
			Utils.setRtLast(Constants.SUC);
		}
		else
		{
			Utils.setRtLast(Constants.FAIL);
		}
	}


	/**
	 * 生成设备超级密码
	 * @return
	 */
	public static String genSPwd()
	{
		// Logger log = LogImpl.getLogger(ComImpl.class);
		String pwdOne = genRandom(Constants.LEN_ONE, Constants.NUMBERS);
		String pwdLast = genRandom(Constants.LEN_SEVEN, Constants.NUMBERZERO);
		String pwd = pwdOne + pwdLast;

		// 返回超级密码，写回客户端
		if (Utils.emptyStr(pwd))
		{
			pwd = Constants.PWD_DEFAULT;
		}

		// 存库

		return pwd;
	}

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
	 * 空判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean emptyArgs(String[] str)
	{
		boolean flag = true;
		if (null != str && str.length > 0)
		{
			flag = false;
		}
		return flag;
	}

	/**
	 * 
	 * @param src
	 * @param code
	 * @return
	 */
	public static String[] splitStr(String src, String code)
	{
		String[] descSrc = src.split(code);

		return descSrc;
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
			outer = Constants.OUTER_HEART;
		}
		return outer;
	}

	/**
	 * 
	 * @param innerType
	 * @return
	 */
	public static String outerToInner(String innerType)
	{
		String outer = "";
		if (Constants.OUTER_SUB_LOCK_LOCATION.equals(innerType))
		{
			outer = Constants.INNER_LOCK_LOCATION;
		}
		else if (Constants.OUTER_SUB_LOCK_POI.equals(innerType))
		{
			outer = Constants.INNER_LOCK_POI;
		}
		else if (Constants.OUTER_SUB_LOCK_NUMS.equals(innerType))
		{
			outer = Constants.INNER_LOCK_NUM;
		}
		else if (Constants.OUTER_SUB_LOCK_FORCE.equals(innerType))
		{
			outer = Constants.INNER_LOCK_FORCE;
		}
		else if (Constants.OUTER_STUFF.equals(innerType))
		{
			outer = Constants.INNER_ADDSTUFF;
		}
		else if (Constants.OUTER_SPWD.equals(innerType))
		{
			outer = Constants.INNER_UPSPWD;
		}
		else if (Constants.OUTER_MODULE.equals(innerType))
		{
			outer = Constants.INNER_UPMODULE;
		}
		else if (Constants.OUTER_HEART.equals(innerType))
		{
			outer = Constants.INNER_HEART_TEST;
		}
		return outer;
	}

	public static String getOtherType(String ltype)
	{
		String rt = "";
		if (!emptyStr(ltype))
		{
			if (ltype.length() == 4)
			{
				rt = innerToOuter(ltype);
			}
			else if (ltype.length() == 5)
			{
				rt = outerToInner(ltype);
			}
		}
		return rt;
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

	/**
	 * 
	 * @param args
	 * @return
	 */
	public static String getStrFromArgs_old(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		if (!emptyArgs(args))
		{
			for (int i = 0; i < args.length; i++)
			{
				String str = args[i];
				if (!emptyStr(str))
				{
					if (i != args.length - 1)
					{
						sb.append(str).append(",");
					}
					else
					{
						sb.append(str);
					}
				}
			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param args
	 * @return
	 */
	public static String getStrFromArgs(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		if (!emptyArgs(args))
		{
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < args.length; i++)
			{
				if (!emptyStr(args[i]))
				{
					set.add(args[i]);
				}
			}
			String[] arrayResult = (String[]) set.toArray(new String[set.size()]);

			for (int t = 0; t < arrayResult.length; t++)
			{
				String str = arrayResult[t];
				if (t != arrayResult.length - 1)
				{
					sb.append(str).append(",");
				}
				else
				{
					sb.append(str);
				}
			}
			System.out.println("lat = " + sb.toString());

		}

		return sb.toString();
	}


/*	public static String getStrFromArgsEditCompany(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		if (!emptyArgs(args))
		{
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < args.length; i++)
			{
				if (!emptyStr(args[i]))
				{
					String idTmp = args[i];
					Utils.logSys("idTmp = " + idTmp);
					try
					{
						Integer.parseInt(idTmp);
						set.add(idTmp);
					}
					catch (Exception e)
					{
						try
						{
							idTmp = new String(idTmp.getBytes("ISO-8859-1"), "utf-8");
						}
						catch (UnsupportedEncodingException e1)
						{
							e1.printStackTrace();
						}
						Utils.logSys("idTmp1 = " + idTmp);
						// int idi =
						// Constants.hmCompanyName.get(idTmp).getCid();
						// why-rain
						int idi = DbImpl.getCompanyCid(idTmp);
						if (idi != 0)
						{
							set.add(idi + "");
						}
					}

				}
			}
			String[] arrayResult = (String[]) set.toArray(new String[set.size()]);

			for (int t = 0; t < arrayResult.length; t++)
			{
				String str = arrayResult[t];
				if (t != arrayResult.length - 1)
				{
					sb.append(str).append(",");
				}
				else
				{
					sb.append(str);
				}
			}
			// System.out.println("lat = " + sb.toString());

		}

		return sb.toString();
	}*/


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
	 * @param joClient
	 * @return
	 */
	public static boolean getParamFromJSON(JSONObject joClient, String param)
	{
		if (joClient.containsKey(param))
		{
			return true;
		}

		return false;
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
	 * @param str
	 * @return
	 */
	public static String getStr(String str)
	{
		if (Utils.emptyStr(str))
		{
			str = "";
		}

		return str;
	}

	/**
	 * 
	 * @param dt
	 * @return
	 */
	public static String formatDtDelZero(String dt)
	{
		if (!Utils.emptyStr(dt))
		{
			dt = dt.replaceAll("\\.0", "");
		}
		return dt;
	}

	/**
	 * 
	 * @param dt
	 * @return
	 */
	public static String formatDtYMD(String dt)
	{
		dt = dt.substring(0, dt.indexOf(" "));
		return dt;
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
	 * 
	 * @param startTime
	 * @return
	 */
	public static String getStartTime(String startTime)
	{
		return startTime + Constants.DATE_ZERO;
	}

	/**
	 * 
	 * @param endTime
	 * @return
	 */
	public static String getEndTime(String endTime)
	{
		return endTime + Constants.DATE_NINE;
	}

	private static List removeDuplicateWithOrder(List list)
	{
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();)
		{
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
		Utils.logSys(" remove duplicate " + list);
		
		return list;
	}
}
