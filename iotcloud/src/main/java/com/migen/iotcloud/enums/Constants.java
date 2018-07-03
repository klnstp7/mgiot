package com.migen.iotcloud.enums;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 常量，公共常量
 * 
 * @author fengy
 * 
 */
public class Constants
{
	public static String	          LASTRT	                  = "no data";
	public static String	          SUC	                      = "suc";
	public static String	          FAIL	                      = "fail";
	public static String	          SOCKETSERV_IP	              = "39.108.67.39";
	public static String	          TEST_IP	                  = "127.0.0.1";
	public static int	              SOCKETSERV_PORT	          = 28088;
	public static int	              SERV_IOT_PORT	              = 8080;
	public static int	              SERV_WEB_PORT	              = 8088;

	// 30分
	public static int	              TIMEOUT	                  = 30 * 60 * 1000;

	// 3分
	public static long	              TIMEINTER	                  = 3 * 60 * 1000l;

	public static long	              ZERO	                      = 0l;

	// 存通信socket，key唯一硬件编号
	public static Map<String, Socket>	hmSocket	              = new HashMap<String, Socket>();

	public static int	              LEN_ONE	                  = 1;
    public static int	              LEN_SPWD	               =4;
	public static int	              LEN_SEVEN	                  = 7;
	public static int	              LEN_EIGHT	                  = 8;
    public static char[]	               NUMBERS_SPWD	                   = {'0', '1', '2', '3' };
    // 默认超级密码-硬件模块
    public static String	               SPWD_DEFAULT	               = "32768";

	/**
	 * web-iot通讯模块
	 */
	public static String	          URL_REQ	                  = "http://" + SOCKETSERV_IP + ":" + SERV_IOT_PORT
	                                                                      + "/iotcloud/entry";
	public static String	          URL_FILE	                  = "http://" + SOCKETSERV_IP + ":" + SERV_WEB_PORT
	                                                                      + "/iotcloud/files/";

	public static String	          URL_VERFILE	              = "http://" + SOCKETSERV_IP + ":" + SERV_WEB_PORT
	                                                                      + "/iotcloud/vers/";

	// 所有权限
	public static String	          PRI_ALL	                  = "all";

	public static char[]	          NUMBERS	                  = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static char[]	          NUMBERZERO	              = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static char[]	          NUNBER_LETTERS	          = { '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
	        'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
	        'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	        'W', 'X', 'Y', 'Z'	                                  };

	public static char[]	          NUMBER_LETTERS_SYMBOLS	  = { '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
	        'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
	        'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	        'W', 'X', 'Y', 'Z', '!', '@', '$', '%', '^', '&', '*' };

	// 默认超级密码-硬件模块
	public static String	          PWD_DEFAULT	              = "88888888";

	// 内部通信协议类型
	public static String	          INNER_ISSUE	              = "i101";
	public static String	          INNER_ADDSTUFF	          = "i102";
	public static String	          INNER_UPSPWD	              = "i103";
	public static String	          INNER_UPMODULE	          = "i104";
	public static String	          INNER_DEVICE_ADD	          = "i105";
	public static String	          INNER_DEVICE_EDIT	          = "i106";
	public static String	          INNER_DEVICE_DEL	          = "i107";

	public static String	          INNER_LOCK_NUM	          = "i108";
	public static String	          INNER_LOCK_POI	          = "i109";
	public static String	          INNER_LOCK_FORCE	          = "i110";
	public static String	          INNER_LOCK_LOCATION	      = "i111";
	//新增
	public static String	          INNER_LOCATION	       = "i112";
	public static String	          INNER_INSTALL_YIELD       = "i113";
	public static String	          INNER_REAL_YIELD       = "i114";
	public static String	          INNER_ONLINE      = "i200";
	public static String	          INNER_SEND_HEARTBEAT       = "i300";
	public static String	          INNER_SEND_GPRS       = "i400";
	public static String	          INNER_SEND_COMMAND       = "i999";


	// 强制解锁（锁定原因都解决后进行的解锁）
	public static String	          INNER_UNLOCK_DEVICE	      = "f101";

	// 测试通信是否通畅
	public static String	          INNER_HEART_TEST	          = "h101";
	// 下发配置文件
	public static String	          INNER_CONFIGFILE	          = "h102";
	// 下发开工请求
	public static String	          INNER_START	              = "h103";
	// 重启
	public static String	          INNER_RESTART	              = "h104";
	// 更新版本
	public static String	          INNER_UPVER	              = "h105";
	// 下发内容
	public static String	          INNER_ADS	                  = "h106";
	// 下发图片
	public static String	          INNER_ADSPIC	              = "h107";

	// type socket
	// 接收消息的类型:10001启动start,开工， 10002基本信息base， 10003生产物品stuff， 10004生成超级密码spwd
	// ，10005web下发指令issue，10006重启restart，10007更新模块module,
	// 10008锁定lock，10009告警warn, 10010心跳, 10011位置信息，10012机器关机，模块正常,
	// 10013获得系统时间,10014强制解锁
	// 超级密码子类型subType：20001获取密码，20002更换密码
	// 锁定子类型subType：20003生产完成，20004银行租用到期，20005强制锁定，20006位置移动
	// 告警子类型：subType:20101生产即将完成，20102机械故障，20103银行租用即将到期， 20104机器已锁定，
	// 20105机器异常关机，20106未知故障, 20107智盒编号更换，20108电量不足
	// 告警新字段：info（比如：剩余产量、剩余天数等）
	public static String	          OUTER_START	              = "10001";
	public static String	          OUTER_BASE	              = "10002";
	public static String	          OUTER_STUFF	              = "10003";
	public static String	          OUTER_SPWD	              = "10004";
	public static String	          OUTER_ISSUE	              = "10005";
	public static String	          OUTER_RESTART	              = "10006";
	public static String	          OUTER_MODULE	              = "10007";
	public static String	          OUTER_LOCK	              = "10008";
	public static String	          OUTER_WARN	              = "10009";
	public static String	          OUTER_HEART	              = "10010";
	public static String	          OUTER_LOCATION	          = "10011";
	public static String	          OUTER_OPENCLOSE	          = "10012";
	public static String	          OUTER_GETSYSDT	          = "10013";
	public static String	          OUTER_UNLOCK	              = "10014";

	// 子类型
	public static String	          OUTER_SUB_GETSPWD	          = "20001";
	public static String	          OUTER_SUB_CHANGESPWD	      = "20002";

	public static String	          OUTER_SUB_LOCK_NUMS	      = "20003";
	public static String	          OUTER_SUB_LOCK_POI	      = "20004";
	public static String	          OUTER_SUB_LOCK_FORCE	      = "20005";
	public static String	          OUTER_SUB_LOCK_LOCATION	  = "20006";

	public static String	          OUTER_SUB_UNLOCK_FORCE	  = "30001";
	public static String	          OUTER_SUB_UNLOCK_NUMS	      = "30002";
	public static String	          OUTER_SUB_UNLOCK_POI	      = "30003";
	public static String	          OUTER_SUB_UNLOCK_LOCATION	  = "30004";
	

	public static String	          OUTER_SUB_WARN_NUMS	      = "20101";
	public static String	          OUTER_SUB_WARN_TROUBLE	  = "20102";
	public static String	          OUTER_SUB_WARN_POI	      = "20103";
	public static String	          OUTER_SUB_WARN_LOCK	      = "20104";
	public static String	          OUTER_SUB_WARN_CLOSE	      = "20105";
	public static String	          OUTER_SUB_WARN_OTHER	      = "20106";
	public static String	          OUTER_SUB_WARN_CHANGEID	  = "20107";
	public static String	          OUTER_SUB_WARN_BATTERY	  = "20108";
	public static String	          OUTER_SUB_WARN_CONNCLOSE	  = "20109";

	public static String	          OUTER_SUB_WARN_NUMS_OK	  = "21101";
	public static String	          OUTER_SUB_WARN_TROUBLE_OK	  = "21102";
	public static String	          OUTER_SUB_WARN_POI_OK	      = "21103";
	public static String	          OUTER_SUB_WARN_LOCK_OK	  = "21104";
	public static String	          OUTER_SUB_WARN_CLOSE_OK	  = "21105";
	public static String	          OUTER_SUB_WARN_OTHER_OK	  = "21106";
	public static String	          OUTER_SUB_WARN_CHANGEID_OK	= "21107";
	public static String	          OUTER_SUB_WARN_BATTERY_OK	  = "21108";
	public static String	          OUTER_SUB_WARN_CONNCLOSE_OK	= "21109";

	// 下发指令类型：锁定、告警、

	// 用户等级
	public static int	              USR_SUPER	                  = 10;
	public static int	              USR_MANAGER	              = 11;
	public static int	              USR_COMMON	              = 12;
	public static int	              USR_MINOR	                  = 13;

	// 公司类型
	public static int	              COMPANY_SERVERCE	          = 10;
	public static int	              COMPANY_BANK	              = 11;
	public static int	              COMPANY_MACHINE	          = 12;
	public static int	              COMPANY_LABEL	              = 13;
	public static int	              COMPANY_CAR	              = 14;
	public static int	              COMPANY_AGANT	              = 15;

	// 位置类型
	public static int	              LOCATION_LTYPE_JZ	          = 1;
	public static int	              LOCATION_LTYPE_WIFIJZ	      = 2;

	// public static Map<Integer, CompanyBean> hmCompanyId = new
	// HashMap<Integer, CompanyBean>();
	// public static Map<String, CompanyBean> hmCompanyName = new
	// HashMap<String, CompanyBean>();

	public static String	          MAIL_SEND_USER	          = "wanghongyu@neurosy.cn";
	public static String	          MAIL_SEND_PWDS	          = "Why123456";

	public static String	          MAIL_SEND_SMTPHOST_QQ	      = "smtp.exmail.qq.com";
	public static String	          MAIL_SEND_SMTPHOST_163	  = "smtp.163.com";

	// 收件人邮箱
	public static String	          MAIL_SEND_TESTUSER	      = "158605488@qq.com";

	public static String	          MAIL_SEND_TYPE_SIMPLE	      = "simple";
	public static String	          MAIL_SEND_TYPE_MUL	      = "mul";

	public static String	          MAIL_SUBJECT	              = "设备通知信息";

	public static String	          CODING_ISO88591	          = "ISO-8859-1";
	public static String	          CODING_UTF8	              = "utf-8";

	public static int	              TIME_ZERO	                  = 0;
	public static int	              TIME_ONE	                  = -1;
	public static int	              TIME_FIVE	                  = -5;
	public static int	              TIME_TEN	                  = -10;

	public static String	          DATE_ZERO	                  = " 00:00:00";
	public static String	          DATE_NINE	                  = " 23:59:59";

	public static String	                QUENCE_NAME_ISSUE	   = "ISSUE";

	public static String	                QUENCE_NAME_ONLINE	   = "ONLINE";

	// device锁定
	public static final int	               DEVICE_UNLOCK	           = 1;
	public static final int	               DEVICE_LOCK	               = 2;
	public static final int	               DEVICE_UNLOCKING	           = 3;
	public static final int	               DEVICE_LOCKING	           = 4;

}
