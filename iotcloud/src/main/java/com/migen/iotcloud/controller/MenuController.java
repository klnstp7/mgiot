package com.migen.iotcloud.controller;

import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.ResponseResult;
import com.migen.iotcloud.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }


    @RequestMapping(value = "/gettreegrid")
    @ResponseBody
    public PageVo<Menu> gettreegrid(){
        return menuService.find(null);
    }

    @RequestMapping("/edit")
    public ModelAndView edit(int mid,Integer parentid,String parentname) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mid",mid);
        mv.addObject("parentid",parentid);
        mv.addObject("parentname",parentname);
        return mv;
    }

    @RequestMapping(value = "/getById")
    @ResponseBody
    public Menu getMenuById(int mid){
        return menuService.getMenuById(mid);
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseResult save(Menu menu) {
        ResponseResult result = new ResponseResult();
        boolean isExists=menuService.checkIsExists(menu);
        if(isExists) {
            result.setSuccess(false);
            result.setMessage("菜单不能重复,请重新输入！");
            return result;
        }
        try{
            boolean tmp;
            if(menu.getMid()==0){
                tmp= menuService.insertMenu(menu);
            }else{
                tmp= menuService.updateMenu(menu);
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
    public ResponseResult delete(int mid) {
        ResponseResult result = new ResponseResult();
        try{
            boolean tmp=menuService.deleteMenu(mid);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }
}
