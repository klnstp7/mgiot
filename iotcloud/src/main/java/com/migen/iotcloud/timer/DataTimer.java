package com.migen.iotcloud.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

//import com.why.iotcloud.impl.OutCome;
import com.migen.iotcloud.utils.Utils;

/**
 * 
 * @author fengy
 * 
 */
public class DataTimer
{
	// 24小时，一天的时间
	private static final long	ONEDAY	= 1 * 24 * 60 * 60 * 1000l;
	private static Timer	  timer	   = new Timer();

	/**
	 * 
	 */
	public static void start()
	{
		// 测试环境屏蔽，正式打开
		// implTask();
	}

	/**
	 * 
	 */
	private static void implTask()
	{
		Utils.logSys("------------------implTask");
		/*OutCome OutComeTask = new OutCome();
		Date date = getRunDate(3, 0, 0);
		// 每天的date时刻执行task，
		timer.schedule(OutComeTask, date, ONEDAY);*/
	}

	/**
	 * 
	 * @param hour
	 * @param minute
	 * @param seconds
	 * @return
	 */
	private static Date getRunDate(int hour, int minute, int seconds)
	{
		// 设置执行时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);// 增加一天
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);// 每天
		// 定制每天的3:00:00执行，
		calendar.set(year, month, day, hour, minute, seconds);
		Date date = calendar.getTime();

		Utils.logSys(date.toString());

		return date;
	}

	public static void main(String[] args)
	{
		implTask();
	}

}
