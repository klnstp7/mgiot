package com.migen.myiot.dao;

import com.migen.myiot.entity.LocationRight;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface LocationRightMapper {

    LocationRight getLocationRightByDid(int did);

    int insertLocationRight(LocationRight loctionRight);

    int updateStatus(LocationRight loctionRight);
}
