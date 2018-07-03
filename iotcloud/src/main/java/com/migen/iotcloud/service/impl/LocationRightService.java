package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.dao.LocationRightMapper;
import com.migen.iotcloud.entity.LocationRight;
import com.migen.iotcloud.service.inter.ILocationRightService;
import com.migen.iotcloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 */
@Service
public class LocationRightService implements ILocationRightService {

    @Autowired
    LocationRightMapper locationRightMapper;

    public List<LocationRight> getLocationRightByDid(int did) {
        List<LocationRight> locationRights=locationRightMapper.getLocationRightByDid(did);
        for(LocationRight item:locationRights){
            item.setStrDt(DateUtils.getDateTime(item.getDt()));
        }
        return locationRights;
    }
}
