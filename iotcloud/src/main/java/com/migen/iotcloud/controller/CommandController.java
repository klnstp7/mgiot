package com.migen.iotcloud.controller;

import com.migen.iotcloud.dto.ResponseResult;
import com.migen.iotcloud.utils.UserInfoUtil;
import com.migen.iotcloud.utils.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/command")
public class CommandController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping("/sendcommand")
    @ResponseBody
    public ResponseResult sendcommand(String moduleid, String command) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.sendCommand(moduleid,command, UserInfoUtil.getCurrentUser());
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/sendheartbeat")
    @ResponseBody
    public ResponseResult sendheartbeat(String moduleid,String heartbeat) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.sendHeartBeat(moduleid,heartbeat,UserInfoUtil.getCurrentUser());
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/sendgprs")
    @ResponseBody
    public ResponseResult senduart(String moduleid,String gprs) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.sendGprs(moduleid,gprs,UserInfoUtil.getCurrentUser());
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }
}
