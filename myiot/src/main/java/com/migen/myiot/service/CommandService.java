package com.migen.myiot.service;

import com.migen.myiot.utils.SpringContext;
import com.migen.myiot.dao.CommandMapper;
import com.migen.myiot.entity.Command;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class CommandService {

    static CommandMapper commandMapper= SpringContext.getSqlSession().getMapper(CommandMapper.class);

    public static Command getCmdByCode(String code){
        return commandMapper.getCmdByCode(code);
    }

}
