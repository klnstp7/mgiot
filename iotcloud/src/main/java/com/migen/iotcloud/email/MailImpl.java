package com.migen.iotcloud.email;

import java.util.List;

import com.migen.iotcloud.entity.Warn;
import com.migen.iotcloud.enums.Constants;
import com.migen.iotcloud.utils.ChangeUtils;
import com.migen.iotcloud.utils.Utils;

/**
 * 
 * @author fengy
 * 
 */
public class MailImpl
{
	/**
	 * 处理邮件
	 */
	public static void dealMails()
	{
		// 1、获取分批告警信息
		List<Warn> wbLists =null; //DbWarn.queryPartWarn();
		if (null == wbLists || wbLists.size() == 0)
		{
			return;
		}
		Utils.logSys("需要发送邮件共：" + wbLists.size() + " 封。");
		// 2、组装信息, 发邮件
		for (int i = 0; i < wbLists.size(); i++)
		{
			Warn wbn = wbLists.get(i);
			String content = ChangeUtils.warnType(wbn.getInfo());
			String sendContent = getMailContentFormat(wbn.getUname(), "11", content);
			MailReceive mrb = new MailReceive();
			mrb.setUserMail(wbn.getMail());
			mrb.setContent(sendContent);

			try
			{
				// 发邮件
				MailUtils.send(Constants.MAIL_SEND_TYPE_SIMPLE, mrb);

				// 更新库
				//DbWarn.updateWarnStatus(wbn.getWid());
				//DbWarn.insertWarnMailDetail(wbn);

				// 间隔
				Thread.sleep(10000);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 邮件格式化
	 */
	public static String getMailContentFormat(String uname, String machineName, String curStatus)
	{
		String formatMailStr = String
		        .format("亲爱的%s：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贵公司设备【%s】：-“%s”，请及时处理。"
		        		+ "<br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
		        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
		        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
		        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;neurosy研发部",
		                uname, machineName, curStatus);
		return formatMailStr;
	}
}
