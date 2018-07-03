package com.migen.iotcloud.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.migen.iotcloud.dto.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/2/17.
 */
public class UserInfoUtil {

    /*
    * 获取当前用户信息
    * */
    public static UserInfo getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            UserInfo dto= (UserInfo)session.getAttribute("User");
            return  dto;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    /*
    * 根据用户名获取用户信息
    * */
    public static UserInfo getCurrentUser(String userAccount)
    {

        Properties properties = ReadPropertiesData.readPropertie("config");
        String url = properties.get("permissionurl").toString() + "/account/" + userAccount;
        String result = URLtoJSONandXML.getHttpUrl_new(url, "UTF-8");
        Gson gson=new Gson();
        Map<String, Object> retMap = gson.fromJson(result, new TypeToken<Map<String, Object>>() {
        }.getType());

        UserInfo dto = gson.fromJson(gson.toJson(retMap.get("data")), UserInfo.class);
        return dto;
    }

    /*
    * 获取当前用户所在的公司/部门
    * */
    public static Integer getCurrentUserCompanyId(String userAccount) {
        return getCurrentUser(userAccount).getCid();
    }

    /*
    * 获取当前用户所在的公司/部门
    * */
    public static Integer getCurrentUserCompanyId() {
        return getCurrentUser().getCid();
    }
}
