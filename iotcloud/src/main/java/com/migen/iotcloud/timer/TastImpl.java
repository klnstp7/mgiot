package com.migen.iotcloud.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 
 * @author fengy
 * 
 */
public class TastImpl
{
	public static ScheduledExecutorService	executor	= Executors.newScheduledThreadPool(100);

	/**
	 * 
	 */
	public static void init()
	{
		// 暂时屏蔽发送邮件
		// mailTask();
	}

	/**
	 * 
	 */
	private static void mailTask()
	{
	/*	Runnable runnable = new Runnable()
		{
			public void run()
			{
				Utils.logSys("开始发邮件。。。。。。");
				MailImpl.dealMails();
			}
		};
		// ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		executor.scheduleAtFixedRate(runnable, 2 * 60, 3 * 60, TimeUnit.SECONDS);*/
	}
}
