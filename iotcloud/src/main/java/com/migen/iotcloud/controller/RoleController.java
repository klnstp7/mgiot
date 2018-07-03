package com.migen.iotcloud.controller;

import com.migen.iotcloud.condition.RoleCondition;
import com.migen.iotcloud.dto.RolePriDto;
import com.migen.iotcloud.dto.RoleUserDto;
import com.migen.iotcloud.entity.Role;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView index = new ModelAndView();
        return index;
    }

    @RequestMapping(value = "/getPaging")
    @ResponseBody
    public PageVo<Role> getPaging(RoleCondition condition, int page, int rows){
        return roleService.findByPaging(condition, page, rows);
    }


    @RequestMapping("/edit")
    public ModelAndView edit(int cid,String company, int rid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cid",cid);
        mv.addObject("company",company);
        mv.addObject("rid",rid);
        return mv;
    }

    @RequestMapping(value = "/getById")
    @ResponseBody
    public Role getRoleById(int rid){
        return roleService.getRoleById(rid);
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseResult save(Role role) {
        ResponseResult result = new ResponseResult();
        boolean isExists=roleService.checkIsExists(role);
        if(isExists) {
            result.setSuccess(false);
            result.setMessage("用户名不能重复,请重新输入！");
            return result;
        }
        try{
            boolean tmp;
            if(role.getRid()==0){
                tmp= roleService.insertRole(role);
            }else{
                tmp= roleService.updateRole(role);
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
    public ResponseResult delete(int rid) {
        ResponseResult result = new ResponseResult();
        try{
            boolean tmp=roleService.deleteRole(rid);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/allotpri")
    public ModelAndView allotPri(int cid,String company, int rid,String rname) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cid",cid);
        mv.addObject("company",company);
        mv.addObject("rid",rid);
        mv.addObject("rname",rname);
        return mv;
    }

    @RequestMapping("/getrolepri")
    @ResponseBody
    public  PageVo<RolePriDto> getRolePri(int rid){
        return roleService.getRolePri(rid);
    }

    @RequestMapping("/saverolepri")
    @ResponseBody
    public ResponseResult saveRolePri(int rid,@RequestParam(value = "mids[]")int[] mids) {
        ResponseResult result = new ResponseResult();
        try{
            roleService.saveRolePris(rid,mids);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/allotuser")
    public ModelAndView allotUser(int cid,String company, int rid,String rname) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cid",cid);
        mv.addObject("company",company);
        mv.addObject("rid",rid);
        mv.addObject("rname",rname);
        return mv;
    }

    @RequestMapping("/getroleuser")
    @ResponseBody
    public List<RoleUserDto> getRoleUser(int cid, int rid){
        return roleService.getRoleUser(cid,rid);
    }

    @RequestMapping("/saveroleuser")
    @ResponseBody
    public ResponseResult saveUserRole(int rid,@RequestParam(value = "usrids[]")int[] usrids) {
        ResponseResult result = new ResponseResult();
        try{
            roleService.saveRoleUsers(rid,usrids);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }
}
