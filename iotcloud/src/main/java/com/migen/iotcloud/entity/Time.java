package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 *
 */
public class Time
{
	private static long lastTime = 0;

	public static long getLastTime()
	{
		return lastTime;
	}

	public static void setLastTime(long lastTime)
	{
		Time.lastTime = lastTime;
	}
	
}
