package com.migen.iotcloud.controller;


import com.migen.iotcloud.service.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Lthui on 2017/3/16.
 */
@Controller
public class BaseController {

    @Autowired
    protected IUserService userService;

    @Autowired
    protected IMenuService menuService;

    @Autowired
    protected IUsrPriService usrPriService;

    @Autowired
    protected IDeviceService deviceService;

    @Autowired
    protected ICompanyService companyService;

    @Autowired
    protected ICompanyTypeService companyTypeService;

    @Autowired
    protected IDeviceLockService deviceLockService;

    @Autowired
    protected ILocationRightService locationRightService;

    @Autowired
    protected IWorkTimeService workTimeService;

    @Autowired
    protected IWarnService warnService;

    @Autowired
    protected IRoleService roleService;


    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
}
