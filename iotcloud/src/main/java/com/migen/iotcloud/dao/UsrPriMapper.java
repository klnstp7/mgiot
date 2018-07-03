package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.UsrPri;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface UsrPriMapper {

    UsrPri getUserPri(Map<String,Object> paras);

}
