package com.migen.iotcloud.controller;

import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.ResponseResult;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.dto.UserRoleDto;
import com.migen.iotcloud.entity.User;
import com.migen.iotcloud.utils.DateTimeUtils;
import com.migen.iotcloud.condition.UserCondition;
import com.migen.iotcloud.utils.MD5Util;
import com.migen.iotcloud.utils.UserInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView index = new ModelAndView();
        return index;
    }

    @RequestMapping("/editPwd")
    public ModelAndView editPwd() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping("/updPwd")
    @ResponseBody
    public ResponseResult updPwd (HttpServletRequest request, HttpServletResponse response, String newpass) {
        ResponseResult result = new ResponseResult();
        try{
            UserInfo userInfo= UserInfoUtil.getCurrentUser();
            String md5_pwd = new MD5Util().getMD5ofStr(newpass);
            userInfo.setPwd(md5_pwd);
            userInfo.setDt(DateTimeUtils.dateToString(new Date()));
            userService.updatePassWord(userInfo);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getPaging")
    @ResponseBody
    public PageVo<User> getPaging(UserCondition condition, int page, int rows){
        return userService.findByPaging(condition, page, rows);
    }


    @RequestMapping("/edit")
    public ModelAndView edit(int cid,String company, int usrid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cid",cid);
        mv.addObject("company",company);
        mv.addObject("usrid",usrid);
        return mv;
    }

    @RequestMapping(value = "/getById")
    @ResponseBody
    public User getUserById(int usrid){
        return userService.getUserById(usrid);
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseResult save(User user) {
        ResponseResult result = new ResponseResult();
        boolean isExists=userService.checkIsExists(user);
        if(isExists) {
            result.setSuccess(false);
            result.setMessage("用户名不能重复,请重新输入！");
            return result;
        }
        try{
            boolean tmp;
            if(user.getUsrid()==0){
                String md5_pwd = new MD5Util().getMD5ofStr(user.getPwd());
                user.setPwd(md5_pwd);
                tmp= userService.insertUser(user);
            }else{
                tmp= userService.updateUser(user);
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
    public ResponseResult delete(int usrid) {
        ResponseResult result = new ResponseResult();
        try{
            boolean tmp=userService.deleteUser(usrid);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/allotrole")
    public ModelAndView allotrole(int cid,String company, int usrid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cid",cid);
        mv.addObject("company",company);
        mv.addObject("usrid",usrid);
        return mv;
    }

    @RequestMapping("/getuserrole")
    @ResponseBody
    public  List<UserRoleDto> getUserRole(int cid, int usrid){
        return userService.getUserRole(cid,usrid);
    }

    @RequestMapping("/saveuserrole")
    @ResponseBody
    public ResponseResult saveUserRole(int usrid,@RequestParam(value = "rids[]")int[] rids) {
        ResponseResult result = new ResponseResult();
        try{
            userService.saveUserRoles(usrid,rids);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }
}
