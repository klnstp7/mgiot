package com.migen.myiot.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Created by Administrator on 2018/6/6.
 */
public class BytesUtil {

    /**
     * 将字节数组转换成十六进制字符串
     */
    public static String byteTo16String(byte[] data) {
        StringBuffer buffer = new StringBuffer();
        for (byte b : data) {
            buffer.append(byteTo16String(b));
        }
        return buffer.toString();
    }
    /**
     * 将字节转换成十六进制字符串
     * int转byte对照表
     * [128,255],0,[1,128)
     * [-128,-1],0,[1,128)
     */
    public static String byteTo16String(byte b) {
        StringBuffer buffer = new StringBuffer();
        int aa = (int)b;
        if (aa<0) {
            buffer.append(Integer.toString(aa+256, 16));
        }else if (aa==0) {
            buffer.append("00");
        }else if (aa>0 && aa<=15) {
            buffer.append("0"+Integer.toString(aa, 16));
        }else if (aa>15) {
            buffer.append(Integer.toString(aa, 16));
        }
        return buffer.toString();
    }

    /**16进制字符串转byte[]
     * @param hexStr
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexStr) {
        if (hexStr == null || "".equals(hexStr)) {
            return null;
        }
        try {
            char[] cs = hexStr.toCharArray();
            return Hex.decodeHex(cs);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 截取字节数组
     * @param src
     * @param begin
     * @param count
     * @return
     */
    public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

    //byte 数组与 int 的相互转换
    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    public static byte[] intToByteArrayLowHigh(int a) {
        return new byte[] {
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF),
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF)
        };
    }

    /**
     * short到字节数组的转换
     *
     * @param number
     * @return
     */
    public static byte[] shortToByte(short number){
        byte[] b = new byte[2];
        b[1] = (byte) (number & 0xff);
        b[0] = (byte) ((number >> 8) & 0xff);
        return b;
    }

    /**
     * Byte转整型
     * @param intValue
     * @return
     */
    public  static  int  byteToInt(byte intValue){
        int byteValue;
        int temp = intValue % 256;
        if ( intValue < 0) {
            byteValue =  temp < -128 ? 256 + temp : temp;
        }
        else {
            byteValue =  temp > 127 ? temp - 256 : temp;
        }
        return byteValue;
    }

}
