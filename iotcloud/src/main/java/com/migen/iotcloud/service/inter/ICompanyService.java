package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.condition.CompanyCondition;
import com.migen.iotcloud.dto.CompanyDto;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.Tree;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.entity.Company;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface ICompanyService {

    PageVo<Company> findByPaging(CompanyCondition condition, int page, int rows);

    PageVo<CompanyDto> find(CompanyCondition condition);

    Company getCompanyById(int cid);

    boolean checkIsExists(Company company);

    boolean insertCompany(Company company,UserInfo ub);

    boolean updateCompany(Company company);

    boolean deleteCompany (int cid);

    List<Company> getCompanyByType(String ctype);

    List<Tree> getTree(String parentId);

    List<Integer> getChildIdList(int pid);
}
