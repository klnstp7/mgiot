package com.migen.myiot.service;

import com.migen.myiot.dao.UpSpwdMapper;
import com.migen.myiot.entity.UpSpwd;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class UpSpwdService {

    static UpSpwdMapper upSpwdMapper= SpringContext.getSqlSession().getMapper(UpSpwdMapper.class);

    public static int insertUpSpwd(UpSpwd upSpwd){
        return upSpwdMapper.insertUpSpwd(upSpwd);
    }

}
