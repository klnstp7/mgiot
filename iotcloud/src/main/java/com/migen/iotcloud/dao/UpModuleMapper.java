package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.UpModule;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface UpModuleMapper {

     int insertUpModule(UpModule upModule);

     int deleteUpModule(int did);

}
