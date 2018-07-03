package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.dao.CompanyTypeMapper;
import com.migen.iotcloud.service.inter.ICompanyTypeService;
import com.migen.iotcloud.entity.CompanyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class CompanyTypeService implements ICompanyTypeService {

    @Autowired
    private CompanyTypeMapper companyTypeMapper;

    public List<CompanyType> getAll(){
        return companyTypeMapper.getAll();
    }
}
