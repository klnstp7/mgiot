package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.dao.CompanyTypeMapper;
import com.migen.iotcloud.dto.CompanyDto;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.Tree;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.init.MapperConfig;
import com.migen.iotcloud.service.inter.ICompanyService;
import com.migen.iotcloud.condition.CompanyCondition;
import com.migen.iotcloud.dao.CompanyMapper;
import com.migen.iotcloud.entity.Company;
import com.migen.iotcloud.entity.CompanyType;
import com.migen.iotcloud.enums.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyTypeMapper companyTypeMapper;

    public PageVo<Company> findByPaging(CompanyCondition condition, int page, int rows){
        int total=companyMapper.countByCond(condition);
        PageVo<Company> pageVo=new PageVo<Company>(total);
        condition.setStart((page-1)*rows);
        condition.setLimit(page * rows);
        List<Company> companies=companyMapper.selectByCond(condition);
        pageVo.setRows(companies);
        return pageVo;
    }

    public PageVo<CompanyDto> find(CompanyCondition condition){
        int total=companyMapper.countByCond(condition);
        PageVo<CompanyDto> pageVo=new PageVo<CompanyDto>(total);
        //企业类型
        List<CompanyType> companyTypes=companyTypeMapper.getAll();

        List<CompanyDto> companyDtos=new ArrayList<CompanyDto>();
        List<Company> companies=companyMapper.selectByCond(condition);
        for(Company item :companies){
            CompanyDto dto= MapperConfig.map(item,CompanyDto.class);
            dto.set_parentId(item.getParentid());
            if(item.getParentid()!=null){
                String companyName=companyMapper.getCompanyById(item.getParentid()).getCompany();
                dto.setParentname(companyName);
            }
            companyDtos.add(dto);
        }
        pageVo.setRows(companyDtos);
        return pageVo;
    }

    public Company getCompanyById(int cid){
        Company company=companyMapper.getCompanyById(cid);
        if(company.getParentid()!=null){
            String companyName=companyMapper.getCompanyById(company.getParentid()).getCompany();
            company.setParentname(companyName);
        }
        return company;
    }

    public boolean checkIsExists(Company company){
        return companyMapper.checkIsExists(company)>0;
    }

    public boolean insertCompany(Company company,UserInfo ub){
      /*  String bcid = "";
        if (ub.getUtype() == Constants.USR_SUPER)
        {
            int ucid = ub.getCid();
            if (0 != ucid)
            {
                bcid = ucid + "_";
            }
        }
        else if (ub.getUtype() == Constants.USR_MINOR)
        {
            Company cbSuper = companyMapper.getCompanyById(ub.getCid());
            String bcidSuper = cbSuper.getBcid();
            int ucid = cbSuper.getCid();
            if (!Utils.emptyStr(bcidSuper) && bcidSuper.contains("_"))
            {
                bcid = bcidSuper + ucid + "_";
            }
            else
            {
                bcid = ucid + "_";
            }
        }
        else if (ub.getUtype() == Constants.USR_MANAGER)
        {
            Company cbSuper = companyMapper.getCompanyById(ub.getCid());
            String bcidSuper = cbSuper.getBcid();
            int ucid = cbSuper.getCid();
            if (!Utils.emptyStr(bcidSuper) && bcidSuper.contains("_"))
            {
                bcid = bcidSuper + ucid + "_";
            }
            else
            {
                bcid = ucid + "_";
            }
        }
        entity.setBcid(bcid);*/
        company.setDt(new Date());
        return companyMapper.insertCompany(company)>0;
    }

    public boolean updateCompany(Company company){
        return companyMapper.updateCompany(company)>0;
    }

    public boolean deleteCompany (int cid){
        List<Company> companyList=getCompanyChildList(cid);
        for (Company company:companyList){
            companyMapper.deleteCompany(company.getCid());
        }
        return true;
    }

    public List<Company> getCompanyByType(String ctype){
        List<Integer> list=new ArrayList<Integer>();
        if(ctype.equals("mac")){
            list.add(Constants.COMPANY_MACHINE);
        }else if(ctype.equals("age")){
            list.add(Constants.COMPANY_AGANT);
        }else if(ctype.equals("use")){
            list.add(Constants.COMPANY_LABEL);
            list.add(Constants.COMPANY_CAR);
        }else if(ctype.equals("poi")){
            list.add(Constants.COMPANY_BANK);
        }
        List<Company> companies=companyMapper.getCompanyByType(list);
        return companies;
    }

    public  List<Tree> getTree(String parentId){
        List<Tree> trees=new ArrayList<Tree>();
        List<Company> result=companyMapper.getChildrenByParentId(parentId);
        for (Company item: result) {
            Tree td = new Tree();
            td.setId(item.getCid());
            td.setText(item.getCompany());
            td.setPid(item.getParentid());
            List<Company> childrenList = companyMapper.getChildren(item.getCid());
            if (childrenList.size() > 0)
            {
                td.setState("closed");
            }
            else
            {
                td.setState("open");
            }
            trees.add(td);
        }
        return trees;
    }


    public List<Integer> getChildIdList(int pid){
        List<Integer> returnList = new ArrayList<Integer>();
        returnList.add(pid);

        List<Company> companyList=companyMapper.getAll();
        if (hasChilds(companyList, pid)) {
            List<Company> childs = new ArrayList<Company>();
            childs = getChildList(companyList,pid,childs);
            for(Company company :childs){
                returnList.add(company.getCid());
            }
        }
        return returnList;
    }

   public List<Company> getCompanyChildList(int pid){
       List<Company> childs = new ArrayList<Company>();
       Company company=getCompanyById(pid);
       childs.add(company);

       List<Company> companyList=companyMapper.getAll();
       if (hasChilds(companyList, pid)) {
           childs = getChildList(companyList,pid,childs);
       }
       return childs;
   }

    /**
     * 获取父id下的子集合
     * @param list
     * @param pId
     * @param reList
     * @return
     */
    private  List<Company> getChildList(List<Company> list,int pId,List<Company> reList) {
        for (Company company : list) {
            if (company.getParentid()!=null) {
                if (company.getParentid().equals(pId)) {//查询下级菜单
                    reList.add(company);
                    if (hasChilds(list, company.getCid())) {
                        getChildList(list, company.getCid(), reList);
                    }
                }
            }
        }
        return reList;
    }

    /**
     * 判断是否含有子节点
     * @param list
     * @param pId
     * @return
     */
    private  boolean hasChilds(List<Company> list,int pId) {
        boolean flag = false;
        for (Company company : list) {
            if (company.getParentid()!=null) {
                if (company.getParentid().equals(pId)) {
                    flag=true;
                    break;
                }
            }

        }
        return flag;
    }
}
