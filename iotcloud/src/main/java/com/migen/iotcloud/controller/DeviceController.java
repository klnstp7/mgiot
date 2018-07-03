package com.migen.iotcloud.controller;

import com.migen.iotcloud.condition.DeviceCondition;
import com.migen.iotcloud.condition.WorkTimeCondition;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.ResponseResult;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.entity.Device;
import com.migen.iotcloud.entity.WorkTime;
import com.migen.iotcloud.entity.DeviceLock;
import com.migen.iotcloud.entity.LocationRight;
import com.migen.iotcloud.enums.Constants;
import com.migen.iotcloud.utils.LogUtil;
import com.migen.iotcloud.utils.UserInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",UserInfoUtil.getCurrentUser());
        return mv;
    }


    @RequestMapping(value = "/getPaging")
    @ResponseBody
    public PageVo<Device> getPaging(DeviceCondition condition, int page, int rows){
        UserInfo currentUser=UserInfoUtil.getCurrentUser();
        if (Constants.USR_SUPER != currentUser.getUtype())
        {
            condition.setCid(currentUser.getCid());
        }
        PageVo<Device> pageVo=deviceService.findByPaging(condition, page, rows);
        return pageVo;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(int did) {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping(value = "/getById")
    @ResponseBody
    public Device getById(int did){
        return deviceService.getDeviceById(did);
    }


    @RequestMapping("/save")
    @ResponseBody
    public ResponseResult save(Device device) {
        ResponseResult result = new ResponseResult();
        try{
            int tmp=deviceService.updateDevice(device);
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseResult delete(int did) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.deleteDevice(did, UserInfoUtil.getCurrentUser());
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(int did) {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping("/issueLock")
    @ResponseBody
    public ResponseResult issueLock(int did) {
        ResponseResult result = new ResponseResult();
        try{
            String tmp=deviceService.issueLock(did, UserInfoUtil.getCurrentUser());
            if(tmp.equals(Constants.SUC)){
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
                result.setMessage(tmp);
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/issueUnlock")
    @ResponseBody
    public ResponseResult issueUnlock(int did) {
        ResponseResult result = new ResponseResult();
        try{
            String tmp=deviceService.issueUnLock(did, UserInfoUtil.getCurrentUser());
            if(tmp.equals(Constants.SUC)){
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
                result.setMessage(tmp);
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/updateVer")
    @ResponseBody
    public ResponseResult updateVer(int did) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.updateVer(did, UserInfoUtil.getCurrentUser());
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getLockByDeviceId")
    @ResponseBody
    public List<DeviceLock> getLockByDeviceId(int did){
        List<DeviceLock> deviceLocks=deviceLockService.getLockByDeviceId(did);
        return deviceLocks;
    }

    @RequestMapping(value = "/getLocationRightByDid")
    @ResponseBody
    public List<LocationRight> getLocationRightByDid(int did){
        List<LocationRight> locationRights=locationRightService.getLocationRightByDid(did);
        return locationRights;
    }

    @RequestMapping("/addnum")
    public ModelAndView addnum(int did) {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping("/saveNums")
    @ResponseBody
    public ResponseResult saveNums(int did,int addNum) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.saveNums(did,addNum, UserInfoUtil.getCurrentUser());
            result.setSuccess(true);
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/getWorkTimePaging")
    @ResponseBody
    public PageVo<WorkTime> getWorkTimePaging(WorkTimeCondition condition, int page, int rows){
        PageVo<WorkTime> pageVo=workTimeService.findByPaging(condition, page, rows);
        return pageVo;
    }

    @RequestMapping("/upmodule")
    public ModelAndView upmodule(int did) {
        ModelAndView mv = new ModelAndView();
        return mv;
    }



    @RequestMapping("/savemodule")
    @ResponseBody
    public ResponseResult savemodule(int did,String moduleid) {
        ResponseResult result = new ResponseResult();
        try{
            String tmp=deviceService.saveModule(did,moduleid, UserInfoUtil.getCurrentUser());
            if(tmp.equals(Constants.SUC)){
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
                result.setMessage(tmp);
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            LogUtil.error(ex.getMessage());
            result.setMessage(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("/issuespwd")
    @ResponseBody
    public ResponseResult issuespwd(int did) {
        ResponseResult result = new ResponseResult();
        try{
            deviceService.issuespwd(did,UserInfoUtil.getCurrentUser());
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
