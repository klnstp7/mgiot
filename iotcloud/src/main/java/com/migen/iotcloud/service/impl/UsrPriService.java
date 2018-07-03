package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.entity.UsrPri;
import com.migen.iotcloud.service.inter.IUsrPriService;
import com.migen.iotcloud.dao.UsrPriMapper;
import com.migen.iotcloud.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class UsrPriService implements IUsrPriService {

    @Autowired
    private UsrPriMapper usrPriMapper;

    /**
     * 获取用户权限
     * @param userName
     * @return
     */
    public UsrPri getUserPri(String userName){
        Map<String,Object> paras=new HashMap<String,Object>();
        if(!StringUtil.isNullOrEmpty(userName)){
            paras.put("uname",userName);
        }
        return usrPriMapper.getUserPri(paras);
    }


}
