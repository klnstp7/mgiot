package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.dao.UserMapper;
import com.migen.iotcloud.entity.User;
import com.migen.iotcloud.init.MapperConfig;
import com.migen.iotcloud.service.inter.ICompanyService;
import com.migen.iotcloud.service.inter.IUserService;
import com.migen.iotcloud.condition.UserCondition;
import com.migen.iotcloud.dao.RoleMapper;
import com.migen.iotcloud.dao.UserRoleMapper;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.dto.UserRoleDto;
import com.migen.iotcloud.entity.Role;
import com.migen.iotcloud.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public User getUserByPwd(String loginName, String password){
        User user = new User();
        user.setUname(loginName);
        user.setPwd(password);
        User result=userMapper.getUserByPwd(user);
        return result;
    }

    public  int updatePassWord(UserInfo userInfo){
        User user= MapperConfig.map(userInfo,User.class);
       return userMapper.updatePassWord(user);
    }


    public  PageVo<User> findByPaging(UserCondition condition, int page, int rows){
        if(condition.getCid()!=0) {
            List<Integer> cidList=companyService.getChildIdList(condition.getCid());
            condition.setCidList(cidList);
        }

        int total=userMapper.countByCond(condition);
        PageVo<User> pageVo=new PageVo<User>(total);
        condition.setStart((page-1)*rows);
        condition.setLimit(page * rows);
        List<User> users=userMapper.selectByCond(condition);
        pageVo.setRows(users);
        return pageVo;
    }

    public User getUserById(int usrid){
        return userMapper.getUserById(usrid);
    }

    public boolean checkIsExists(User user){
        return userMapper.checkIsExists(user)>0;
    }

    public boolean insertUser(User user){
        user.setDt(new Date());
        return userMapper.insertUser(user)>0;
    }

    public boolean updateUser(User user){
        return userMapper.updateUser(user)>0;
    }

    public boolean deleteUser(int usrid){
        userRoleMapper.deleteUserRoleByUserId(usrid);
        userMapper.deleteUser(usrid);
        return true;
    }

    /**
     * 角色分配
     * @param cid
     * @param usrid
     * @return
     */
    public List<UserRoleDto> getUserRole(int cid, int usrid){
        List<UserRoleDto> userRoleDtoList=new ArrayList<UserRoleDto>();
        List<Role> roleList=roleMapper.getRoleByCid(cid);//公司角色
        //用户已分配角色
        List<Integer> roleIdList=new ArrayList<Integer>();
        List<UserRole> userRoleList=userRoleMapper.getRoleByUserId(usrid);
        for(UserRole userRole :userRoleList){
            roleIdList.add(userRole.getRid());
        }
       //返回角色列表
        for(Role role :roleList){
            UserRoleDto userRoleDto=new UserRoleDto();
            userRoleDto.setRid(role.getRid());
            if(roleIdList.contains(role.getRid())){
                userRoleDto.setCk(true);
            }else{
                userRoleDto.setCk(false);
            }
            userRoleDto.setRname(role.getRname());
            userRoleDtoList.add(userRoleDto);
        }
        return userRoleDtoList;
    }

    /**
     * 保存角色
     * @param usrid
     * @param rids
     */
    public void saveUserRoles(int usrid,int[] rids){
        userRoleMapper.deleteUserRoleByUserId(usrid);
        if(rids!=null){
            for (int rid:rids) {
                UserRole userRole=new UserRole();
                userRole.setUsrid(usrid);
                userRole.setRid(rid);
                userRole.setDt(new Date());
                userRoleMapper.insertUserRole(userRole);
            }
        }

    }
}
