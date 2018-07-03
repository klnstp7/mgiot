package com.migen.myiot.dao;

import com.migen.myiot.entity.Warn;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface WarnMapper {

    int insertWarn(Warn warn);
}
