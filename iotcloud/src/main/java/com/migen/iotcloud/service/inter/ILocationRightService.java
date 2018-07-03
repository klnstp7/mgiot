package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.entity.LocationRight;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 */
public interface  ILocationRightService {

    List<LocationRight> getLocationRightByDid(int did);
}
