package com.migen.iotcloud.dto;

import java.util.Date;

/**
 * 用户信息表
 * 
 * @author fengy
 * 
 */
public class RoleUserDto
{
	private int	   usrid;
	private String	uname;
	private String	mail;
	private boolean	 ck;

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public int getUsrid()
	{
		return usrid;
	}

	public void setUsrid(int usrid)
	{
		this.usrid = usrid;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}


	public boolean getCk()
	{
		return ck;
	}

	public void setCk(boolean ck)
	{
		this.ck = ck;
	}
}
