package com.migen.iotcloud.controller;

import com.migen.iotcloud.condition.WarnCondition;
import com.migen.iotcloud.entity.WarnMonitor;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.utils.UserInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/warn")
public class WarnController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",UserInfoUtil.getCurrentUser());
        return mv;
    }

    @RequestMapping(value = "/getPaging")
    @ResponseBody
    public PageVo<WarnMonitor> getPaging(WarnCondition condition, int page, int rows){
        PageVo<WarnMonitor> pageVo=warnService.findByPaging(condition, page, rows);
        return pageVo;
    }
}
