package com.migen.myiot.utils;

import com.migen.myiot.entity.LocationRight;
import net.sf.json.JSONObject;


/**
 * 地图接口,高德地图
 */
public class MapUtils
{
    public static String mapUrl="http://restapi.amap.com/v3";
    public static String key="153a511adbb12af1d8108e9760a8dafe";
    /**
     * GPS坐标转换
     * @param gpsLocation
     * @return
     */
    public static String convertGPSCoordinate(String gpsLocation){
        String  gpsLoc=null;
        String  requestUrl=mapUrl+"/assistant/coordinate/convert?&key="+key+"&locations="+gpsLocation+"&coordsys=gps&output=JSON";
        String result=HttpUtil.sendGet(requestUrl);
        JSONObject json= JSONObject.fromObject(result);
        if(json.getString("status").equals("1")){
            gpsLoc=json.getString("locations");
        }
        return gpsLoc;
    }

    /**
     * 根据坐标获取地址
     * @param trasferLocation
     * @return
     */
    public static void getMapLocation(String trasferLocation,LocationRight ltb){
        String  requestUrl=mapUrl+"/geocode/regeo?&key="+key+"&location="+trasferLocation+"&output=JSON";
        String result=HttpUtil.sendGet(requestUrl);
        JSONObject basic= JSONObject.fromObject(result);

        if(basic.getString("status").equals("1")){
            JSONObject regeocode=basic.getJSONObject("regeocode");

            //地址元素列表
           JSONObject addressComponent=regeocode.getJSONObject("addressComponent");
            String country,province,city,township,street,number;
            country=addressComponent.getString("country");
            province=addressComponent.getString("province");
            city=addressComponent.getString("city");
            township=addressComponent.getString("township");

            //结构化地址信息
            JSONObject streetNumber=addressComponent.getJSONObject("streetNumber");
            street=streetNumber.getString("street");
            number=streetNumber.getString("number");

            //返回
            ltb.setCountry(country);
            ltb.setProvince(province);
            ltb.setCity(city);

            String formattedAddress=regeocode.getString("formatted_address");
            ltb.setAddress(formattedAddress);

            //ltb.setAddress(province+city+township+street+number);
        }
    }
}
