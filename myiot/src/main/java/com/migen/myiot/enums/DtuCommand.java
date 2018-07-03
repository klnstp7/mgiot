package com.migen.myiot.enums;

/**
 * Created by Administrator on 2018/6/1.
 */
public class DtuCommand {

    public static String	              SEND_POSITION   = "$$$POSITION?$$$";

    public static String                SEND_UPDATE_VERSION  ="$$$UPDATE_FTP#$$$";

    public static String                SEND_HEART_BEAT  ="$$$HEARTBEAT:%s#$$$";

    public static String                SEND_GPRS  ="$$$GPRS:%s#$$$";

    public static String	              REC_SERIAL_NUM	   = "+SN";

    public static String	              REC_POSITION	   = "+POSITION";

    public static String                REC_UPDATE_VERSION  ="+UPDATE FTP GoingOn";

    public static String                 SEN_CMD_STATE  ="$$$STATE?#$$$";

    public static String                 REC_CMD_STATE  ="+STATE";

    public static String                 REC_CMD_HEARTBEAT  ="+HEARTBEAT";

    public static String                 REC_HEARTBEAT  ="414b";

    public static String                 REC_CMD_GPRS  ="+GPRS";


}
