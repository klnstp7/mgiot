package com.migen.iotcloud.utils;

import java.util.Date;

import com.migen.iotcloud.entity.Time;
import com.migen.iotcloud.enums.Constants;

public class TimeImpl
{
	public static int	i	= 1;

	public static boolean timeInter()
	{
		boolean flag = false;
		Date curDate = new Date();

		try
		{
			long lastTime = Time.getLastTime();
			if (Constants.ZERO == lastTime)
			{
				flag = true;
				Time.setLastTime(curDate.getTime());
			}
			else
			{
				long curTimes = curDate.getTime();
				if (curTimes <= lastTime)
				{
					flag = true;
					Time.setLastTime(curDate.getTime());
				}
				else
				{
					long interval = curTimes - lastTime;
					if (interval >= Constants.TIMEINTER)
					{
						System.out.println("第 " + i++ + " 次通信，" + "两个时间相差"
						        + interval / 1000 / 60 + "分");// 会打印出相差分
						flag = true;
						Time.setLastTime(curDate.getTime());
					}
				}
			}

		}
		catch (Exception e)
		{

			e.printStackTrace();
		}

		return flag;
	}

}
