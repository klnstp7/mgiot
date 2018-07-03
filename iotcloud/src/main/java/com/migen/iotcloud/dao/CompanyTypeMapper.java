package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.CompanyType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface CompanyTypeMapper {

    List<CompanyType> getAll();
}
