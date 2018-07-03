package com.migen.iotcloud.controller;


import com.migen.iotcloud.entity.CompanyType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/companytype")
public class CompanyTypeController extends BaseController {

    @RequestMapping(value = "/getall")
    @ResponseBody
    public List<CompanyType> getAll(boolean infirst){
        List<CompanyType> result=companyTypeService.getAll();
        if(infirst) {
            CompanyType first = new CompanyType();
            first.setCtid(0);
            result.add(0, first);
        }
        return result;
    }

}
