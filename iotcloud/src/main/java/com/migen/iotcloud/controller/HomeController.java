package com.migen.iotcloud.controller;

import com.migen.iotcloud.dto.MenuDto;
import com.migen.iotcloud.dto.ResponseResult;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.entity.User;
import com.migen.iotcloud.init.MapperConfig;
import com.migen.iotcloud.utils.UserInfoUtil;
import com.migen.iotcloud.entity.FirstMachine;
import com.migen.iotcloud.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public ResponseResult doLogin(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd){
        ResponseResult result = new ResponseResult();
        try{
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getUserByPwd(userAccount,md5_pwd);
            if(user !=null){
                result.setSuccess(true);
                UserInfo userDto = MapperConfig.map(user,UserInfo.class);
                HttpSession session = request.getSession();
                session.setAttribute("User", userDto);
            }
            else{
                result.setSuccess(false);
                result.setMessage("账号或者密码不正确！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("user", UserInfoUtil.getCurrentUser());
        return mv;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ResponseResult logout(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try{
            HttpSession session = request.getSession();
            session.removeAttribute("User");
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/getUserMenu")
    @ResponseBody
    public List<MenuDto> getUserMenu(HttpServletRequest request, HttpServletResponse response)
    {
        // 获取当前展的节点的id
        String parentid =request.getParameter("id");
        // 根据权限分配菜单
        UserInfo currentUser=UserInfoUtil.getCurrentUser();
        List<MenuDto> treeDTOS = menuService.getChildrenByParentId(parentid,currentUser.getUsrid());
        return treeDTOS;
    }

    @RequestMapping("/first")
    public ModelAndView first(HttpServletRequest request, HttpServletResponse response){
        String searchCondition = request.getParameter("searStr");
        LinkedHashMap<String, LinkedHashMap<String, List<FirstMachine>>> hmProvinceList=deviceService.sortInfos(UserInfoUtil.getCurrentUser(),searchCondition);
        ModelAndView mv = new ModelAndView();
        mv.addObject("searStr",searchCondition);
        mv.addObject("data",hmProvinceList);
        return  mv;
    }


}
