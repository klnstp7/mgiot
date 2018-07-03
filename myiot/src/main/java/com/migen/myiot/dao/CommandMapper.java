package com.migen.myiot.dao;

import com.migen.myiot.entity.Command;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface CommandMapper {

    Command getCmdByCode(String code);
}
