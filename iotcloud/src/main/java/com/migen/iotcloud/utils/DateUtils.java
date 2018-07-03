package com.migen.iotcloud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.migen.iotcloud.enums.Constants;
import org.apache.commons.lang.StringUtils;

public class DateUtils
{

	public static final long	TIME_MILLIS_ONE_MONTH	= 30 * 24 * 60 * 60 * 1000l;

	public static final long	TIME_MILLIS_ONE_DAY	   = 24 * 60 * 60 * 1000l;

	public static final long	TIME_MILLIS_ONE_HOUR	= 60 * 60 * 1000l;

	public static final long	TIME_MILLIS_ONE_MINUTE	= 60 * 1000l;

	/**
	 * 返回以毫秒为单位的当前时�?
	 * 
	 * @return long
	 */
	public static long getNowDate()
	{
		return System.currentTimeMillis();
	}

	/**
	 * 返回以秒为单位的当前时间
	 * 
	 * @return long
	 */
	public static long getNowDateSeconds()
	{
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 返回以毫秒为单位的今天开始时�?
	 * 
	 * @return long
	 */
	public static long getTodayStartTime()
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 返回以毫秒为单位的今天结束时�?
	 * 
	 * @return long
	 */
	public static long getTodayEndTime()
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.MILLISECOND, 999);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 返回以毫秒为单位的指定时间的当天�?始时�?
	 * 
	 * @return long
	 */
	public static long getStartTime(Date date)
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.setTime(date);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 返回以毫秒为单位的指定时间的当天结束时间
	 * 
	 * @return long
	 */
	public static long getEndTime(Date date)
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.setTime(date);
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.MILLISECOND, 999);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 返回以毫秒为单位的昨天开始时�?
	 * 
	 * @return long
	 */
	public static long getYesterdayStartTime()
	{
		return getTodayStartTime() - TIME_MILLIS_ONE_DAY;
	}

	/**
	 * 返回以毫秒为单位的昨天结束时�?
	 * 
	 * @return long
	 */
	public static long getYesterdayEndTime()
	{
		return getTodayEndTime() - TIME_MILLIS_ONE_DAY;
	}

	/**
	 * 返回以毫秒为单位的这个月第一天开始时�?
	 * 
	 * @return long
	 */
	public static long getMonthStartDateTime()
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.set(Calendar.DAY_OF_MONTH, 1);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 返回以毫秒为单位的这个月第一天结束时�?
	 * 
	 * @return long
	 */
	public static long getMonthEndDateTime()
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.set(Calendar.DAY_OF_MONTH, 1);
		currentDate.roll(Calendar.DAY_OF_MONTH, -1);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		return currentDate.getTimeInMillis();
	}

	public static long getMonthStartTime()
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.set(Calendar.DAY_OF_MONTH, 1);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		return currentDate.getTimeInMillis();
	}

	public static long getMonthEndTime()
	{
		Calendar currentDate = new GregorianCalendar();
		currentDate.set(Calendar.DAY_OF_MONTH, 1);
		currentDate.roll(Calendar.DAY_OF_MONTH, -1);
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.MILLISECOND, 999);
		return currentDate.getTimeInMillis();
	}

	public static long getEndTimeByDate(Date date)
	{
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(date);
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.MILLISECOND, 999);

		return currentDate.getTimeInMillis();
	}

	/**
	 * 获取指定时间几天前的时间
	 * 
	 * @param Date
	 * @return Date
	 */
	public static Date getDateBefore(Date d, int day)
	{
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	public static Date getDateBeforeWeek(Date d, int day)
	{
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.add(Calendar.WEEK_OF_MONTH, day);
		return now.getTime();
	}

	public static Date getDateBeforeMonth(Date d, int day)
	{
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.add(Calendar.MONTH, day);
		return now.getTime();
	}

	public static long getMondayOfThisWeek(Date day)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 1);

		return c.getTimeInMillis();
	}

	/**
	 * 通过格式化的字符串的到时�?
	 */
	public static Date getDateFromStr(String str)
	{
		try
		{
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化时�?
	 * 
	 * @param date
	 */
	public static String getDateTime(Date date)
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateYMD(Date date)
	{
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * 格式化时�?
	 * 
	 * @param date
	 */
	public static String getDateTimeYMDHMS(Date date)
	{
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	/**
	 * 验证格式化字符串是不�? 时间格式(HH:mm:ss)
	 * 
	 * @param String
	 */
	public static boolean isValidTime(String time)
	{
		if (StringUtils.isEmpty(time))
		{
			return false;
		}
		String[] parts = time.split(":");
		if (parts == null || parts.length != 3)
		{
			return false;
		}
		return true;
	}

	/**
	 * �?(HH:mm:ss)获取小时�?
	 * 
	 * @param String
	 */
	public static int getHour(String time)
	{
		if (isValidTime(time))
		{
			String[] parts = time.split(":");
			if (parts != null && parts.length == 3)
			{
				try
				{
					int hour = Integer.parseInt(parts[0]);
					if (hour >= 0 && hour <= 24)
					{
						return hour;
					}
				}
				catch (Exception e)
				{
				}
			}
		}
		return 0;
	}

	/**
	 * �?(HH:mm:ss)获取分钟�?
	 * 
	 * @param String
	 */
	public static int getMinute(String time)
	{
		if (isValidTime(time))
		{
			String[] parts = time.split(":");
			if (parts != null && parts.length == 3)
			{
				try
				{
					int minute = Integer.parseInt(parts[1]);
					if (minute >= 0 && minute <= 59)
					{
						return minute;
					}
				}
				catch (Exception e)
				{
				}
			}
		}
		return 0;
	}

	/**
	 * �?(HH:mm:ss)获取�?
	 * 
	 * @param String
	 */
	public static int getSecond(String time)
	{
		if (isValidTime(time))
		{
			String[] parts = time.split(":");
			if (parts != null && parts.length == 3)
			{
				try
				{
					int second = Integer.parseInt(parts[2]);
					if (second >= 0 && second <= 59)
					{
						return second;
					}
				}
				catch (Exception e)
				{
				}
			}
		}
		return 0;
	}

	/**
	 * 获取当前时间小时�?
	 */
	public static int getCurrentHour()
	{
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取当前时间分钟�?
	 */
	public static int getCurrentMinute()
	{
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 获取当前时间�?
	 */
	public static int getCurrentSecond()
	{
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.SECOND);
	}

	public static Date getTime(int hour)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();

		if (date.before(new Date()))
		{
			date = addDay(date, 1);
		}
		return date;
	}

	public static Date addDay(Date date, int num)
	{
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}

	public static Date MillisToTime(long time)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date(time));

		return getDateFromStr(date);
	}

	public static String getDtFromLong(long t)
	{
		return getDateTime(MillisToTime(t));
	}

	/**
	 * 获得指定日期的前后多少天
	 * 
	 * @param date
	 * @param num
	 * @return
	 */
	public static String getDayBefore(Date date, int num)
	{
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		date = calendar.getTime();
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 
	 * @return
	 */
	public static String nowBefore()
	{
		String dt = getDayBefore(new Date(), -1);
		dt = dt + Constants.DATE_ZERO;
		return dt;
	}

	/**
	 * 
	 * @return
	 */
	public static String nowCur()
	{
		String dt = getDayBefore(new Date(), 0);
		dt = dt + Constants.DATE_ZERO;
		return dt;
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            Utils.logSys("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

	public static void main(String[] args)
	{
		// System.out.print("s"+DateUtils.getNowDateSeconds()+new
		// Random().nextInt(9999));
		// System.out.println(getDateFromStr("2015-03-01 00:00:00").getTime());
		// System.out.println(new Date(getMonthEndTime()));
		// System.out.println(getTodayStartTime());
		// System.out.println(getYesterdayStartTime());
		// System.out.println(getDateToStr(new Date(1381334228718l)));
		// System.out.println(getTodayStartTime()-DateUtils.TIME_MILLIS_ONE_HOUR*14);//1389456000000
		System.out.println(getCurrentHour());
		// System.out.println(getDateFromStr("2015-12-01 00:00:00").getTime());
		// System.out.println(getDateFromStr("2015-12-30 00:00:00").getTime());
		// System.out.println(getDateFromStr("2015-11-10 00:00:00").getTime());
		// System.out.println(getDateFromStr("2015-07-30 23:59:59").getTime());
		// System.out.println(MillisToTime(1440518400000L));
		// System.out.println(DateUtils.getTodayStartTime());
		// System.out.println(getDateFromStr("1456934400000L"));
		// long end = System.currentTimeMillis() -
		// DateUtils.TIME_MILLIS_ONE_DAY*44;
		// end = DateUtils.getStartTime(new Date(end));
		// System.out.print(end);

		// System.out.println(getDate(new Date()).substring(5,10));
		// System.out.println(getMinute("2016-01-30 21:33:29"));
		// System.out.println(getSecond("2016-01-30 21:33:29"));

	}

}
