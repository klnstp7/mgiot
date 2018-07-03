package com.migen.myiot.dao;

import com.migen.myiot.entity.Stuff;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface StuffMapper {

    int insertStuff(Stuff stuff);

}
