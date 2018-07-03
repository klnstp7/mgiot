package com.migen.myiot.service;

import com.migen.myiot.dao.WarnMapper;
import com.migen.myiot.entity.Warn;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class WarnService {

    static WarnMapper warnMapper= SpringContext.getSqlSession().getMapper(WarnMapper.class);

    public static int insertWarn(Warn warn){
        return warnMapper.insertWarn(warn);
    }

}
