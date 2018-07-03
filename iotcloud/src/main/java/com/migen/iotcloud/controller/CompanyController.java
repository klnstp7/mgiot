package com.migen.iotcloud.controller;


import com.migen.iotcloud.condition.CompanyCondition;
import com.migen.iotcloud.dto.CompanyDto;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.ResponseResult;
import com.migen.iotcloud.dto.Tree;
import com.migen.iotcloud.utils.UserInfoUtil;
import com.migen.iotcloud.entity.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping(value = "/getPaging")
    @ResponseBody
    public PageVo<Company> getPaging(CompanyCondition condition, int page, int rows){
        return companyService.findByPaging(condition, page, rows);
    }

    @RequestMapping(value = "/gettreegrid")
    @ResponseBody
    public PageVo<CompanyDto> gettreegrid(CompanyCondition condition){
        return companyService.find(condition);
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer cid,Integer parentid,String parentname) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cid",cid);
        mv.addObject("parentid",parentid);
        mv.addObject("parentname",parentname);
        return mv;
    }

    @RequestMapping(value = "/getById")
    @ResponseBody
    public Company getCompanyById(int cid){
        return companyService.getCompanyById(cid);
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseResult save(Company company) {
        ResponseResult result = new ResponseResult();
        boolean isExists=companyService.checkIsExists(company);
        if(isExists) {
            result.setSuccess(false);
            result.setMessage("企业不能重复,请重新输入！");
            return result;
        }
        try{
            boolean tmp;
            if(company.getCid()==0){
                tmp= companyService.insertCompany(company, UserInfoUtil.getCurrentUser());
            }else{
                tmp= companyService.updateCompany(company);
            }
            result.setSuccess(tmp);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseResult delete(int cid) {
        ResponseResult result = new ResponseResult();
        try{
            boolean tmp=companyService.deleteCompany(cid);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getByType")
    @ResponseBody
    public List<Company> getByType(String ctype){
        List<Company> result=companyService.getCompanyByType(ctype);
        Company first=new Company();
        first.setCid(0);
        result.add(0,first);
        return result;
    }

    @RequestMapping(value = "/gettree")
    @ResponseBody
    public List<Tree> gettree(){
        // 获取当前展的节点的id
        String parentId = request.getParameter("id");
        List<Tree> trees = companyService.getTree(parentId);
        return trees;
    }

}
