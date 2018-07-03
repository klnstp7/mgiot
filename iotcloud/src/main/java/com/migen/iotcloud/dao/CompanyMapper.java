package com.migen.iotcloud.dao;

import com.migen.iotcloud.condition.CompanyCondition;
import com.migen.iotcloud.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface CompanyMapper {

    List<Company> getAll();

    int countByCond(CompanyCondition Cond);

    List<Company> selectByCond(CompanyCondition Cond);

    Company getCompanyById(int cid);

    int checkIsExists(Company entity);

    int insertCompany(Company entity);

    int updateCompany(Company entity);

    int deleteCompany(int cid);

    List<Company> getCompanyByType(List<Integer> list);

    List<Company> getChildrenByParentId(String parentid);

    List<Company> getChildren(int parentid);
}
