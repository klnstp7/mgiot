package com.migen.myiot.service;

import com.migen.myiot.dao.StuffMapper;
import com.migen.myiot.entity.Stuff;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class StuffService {

    static StuffMapper stuffMapper= SpringContext.getSqlSession().getMapper(StuffMapper.class);

    public static int insertStuff(Stuff stuff){
        return stuffMapper.insertStuff(stuff);
    }

}
