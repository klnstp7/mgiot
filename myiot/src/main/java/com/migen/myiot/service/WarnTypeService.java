package com.migen.myiot.service;

import com.migen.myiot.dao.WarnTypeMapper;
import com.migen.myiot.entity.WarnType;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class WarnTypeService {

    static WarnTypeMapper warnTypeMapper= SpringContext.getSqlSession().getMapper(WarnTypeMapper.class);

    public static WarnType getWarnTypeById(int wtype){
        return warnTypeMapper.getWarnTypeById(wtype);
    }

}
