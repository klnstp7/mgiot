package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.condition.MenuCondition;
import com.migen.iotcloud.condition.RoleCondition;
import com.migen.iotcloud.dao.*;
import com.migen.iotcloud.dto.RolePriDto;
import com.migen.iotcloud.dto.RoleUserDto;
import com.migen.iotcloud.entity.*;
import com.migen.iotcloud.init.MapperConfig;
import com.migen.iotcloud.service.inter.ICompanyService;
import com.migen.iotcloud.service.inter.IRoleService;
import com.migen.iotcloud.dto.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RolePriMapper rolePriMapper;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserMapper userMapper;


    public  PageVo<Role> findByPaging(RoleCondition condition, int page, int rows){
        if(condition.getCid()!=0) {
            List<Integer> cidList=companyService.getChildIdList(condition.getCid());
            condition.setCidList(cidList);
        }

        int total=roleMapper.countByCond(condition);
        PageVo<Role> pageVo=new PageVo<Role>(total);
        condition.setStart((page-1)*rows);
        condition.setLimit(page * rows);
        List<Role> Roles=roleMapper.selectByCond(condition);
        pageVo.setRows(Roles);
        return pageVo;
    }

    public Role getRoleById(int rid){
        return roleMapper.getRoleById(rid);
    }

    public boolean checkIsExists(Role Role){
        return roleMapper.checkIsExists(Role)>0;
    }

    public boolean insertRole(Role Role){
        Role.setDt(new Date());
        return roleMapper.insertRole(Role)>0;
    }

    public boolean updateRole(Role Role){
        return roleMapper.updateRole(Role)>0;
    }

    public boolean deleteRole(int rid){
        userRoleMapper.deleteUserRoleByRoleId(rid);
        rolePriMapper.deletePriByRid(rid);
        roleMapper.deleteRole(rid);
        return true;
    }

    /**
     * 功能菜单分配
     * @param rid
     * @return
     */
    public PageVo<RolePriDto> getRolePri(int rid){
        //角色已分配权限
        List<RolePri> rolePriList=rolePriMapper.getPriByRoleId(rid);
        List<Integer> rolePriIdList=new ArrayList<Integer>();
        for(RolePri rolePri :rolePriList){
            rolePriIdList.add(rolePri.getMid());
        }

        List<RolePriDto> rolePriDtoList=new ArrayList<RolePriDto>();
        MenuCondition condition=new MenuCondition();
        condition.setVisible(true);
        int total=menuMapper.countByCond(condition);
        List<Menu> menuList=menuMapper.selectByCond(condition);
        for(Menu menu :menuList){
            RolePriDto rolePriDto= MapperConfig.map(menu,RolePriDto.class);
            rolePriDto.set_parentId(menu.getParentid());
            if(rolePriIdList.contains(menu.getMid())){
                rolePriDto.setCk(true);
            }else{
                rolePriDto.setCk(false);
            }

            rolePriDtoList.add(rolePriDto);
        }
        PageVo<RolePriDto> pageVo=new PageVo<RolePriDto>(total);
        pageVo.setRows(rolePriDtoList);
        return pageVo;
    }

    /**
     * 保存功能菜单
     * @param rid
     * @param mids
     */
    public void saveRolePris(int rid,int[] mids){
        rolePriMapper.deletePriByRid(rid);
        if(mids!=null){
            for (int mid:mids) {
                RolePri rolePri=new RolePri();
                rolePri.setRid(rid);
                rolePri.setMid(mid);
                rolePri.setDt(new Date());
                rolePriMapper.insertRolePri(rolePri);
            }
        }

    }

    /**
     * 分配用户
     * @param cid
     * @param rid
     * @return
     */
    public List<RoleUserDto> getRoleUser(int cid, int rid){
        List<RoleUserDto> roleUserDtoList=new ArrayList<RoleUserDto>();
        //已分配用户
        List<Integer> usrIdList=new ArrayList<Integer>();
        List<UserRole> userRoleList=userRoleMapper.getUserByRid(rid);
        for(UserRole userRole :userRoleList){
            usrIdList.add(userRole.getUsrid());
        }
        //所有用户
        List<User> userList=userMapper.getUserByCid(cid);
        for(User user :userList){
            RoleUserDto roleUserDto=new RoleUserDto();
            roleUserDto.setUsrid(user.getUsrid());
            if(usrIdList.contains(user.getUsrid())){
                roleUserDto.setCk(true);
            }else{
                roleUserDto.setCk(false);
            }
            roleUserDto.setUname(user.getUname());
            roleUserDtoList.add(roleUserDto);
        }
        return roleUserDtoList;
    }

    /**
     * 保存分配用户
     * @param rid
     * @param usrids
     */
    public void saveRoleUsers(int rid,int[] usrids){
        userRoleMapper.deleteUserRoleByRoleId(rid);
        if(usrids!=null){
            for (int usrid:usrids) {
                UserRole userRole=new UserRole();
                userRole.setUsrid(usrid);
                userRole.setRid(rid);
                userRole.setDt(new Date());
                userRoleMapper.insertUserRole(userRole);
            }
        }
    }
}
