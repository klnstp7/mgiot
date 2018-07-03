package com.migen.myiot.service;

import com.migen.myiot.dao.LocationRightMapper;
import com.migen.myiot.entity.LocationRight;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */

public class LocationRightService   {

    static LocationRightMapper locationRightMapper= SpringContext.getSqlSession().getMapper(LocationRightMapper.class);

    public static LocationRight getLocationRightByDid(int did){
        return locationRightMapper.getLocationRightByDid(did);
    }

    public static int insertLocationRight(LocationRight loctionRight){
        return locationRightMapper.insertLocationRight(loctionRight);
    }

    public static int updateStatus(LocationRight loctionRight){
        return locationRightMapper.updateStatus(loctionRight);
    }

}
