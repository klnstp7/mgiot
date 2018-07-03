package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.condition.RoleCondition;
import com.migen.iotcloud.dto.RolePriDto;
import com.migen.iotcloud.dto.RoleUserDto;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IRoleService {


    PageVo<Role> findByPaging(RoleCondition condition, int page, int rows);

    Role getRoleById(int rid);

    boolean checkIsExists(Role role);

    boolean insertRole(Role role);

    boolean updateRole(Role role);

    boolean deleteRole(int rid);

    PageVo<RolePriDto> getRolePri(int rid);

    void saveRolePris(int rid,int[] mids);

    List<RoleUserDto> getRoleUser(int cid, int rid);

    void saveRoleUsers(int rid,int[] usrids);
}
