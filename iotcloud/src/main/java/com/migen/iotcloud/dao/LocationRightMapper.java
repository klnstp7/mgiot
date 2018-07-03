package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.LocationRight;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface LocationRightMapper {

    List<LocationRight> getLocationRightByDid(int did);

    int deleteLocationRight(int did);
}
