package com.migen.iotcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/usrpri")
public class UsrPriController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
}
