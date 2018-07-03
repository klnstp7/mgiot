package com.migen.iotcloud.dao;

import com.migen.iotcloud.condition.RoleCondition;
import com.migen.iotcloud.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface RoleMapper {

    int countByCond(RoleCondition Cond);

    List<Role> selectByCond(RoleCondition Cond);

    Role getRoleById(int usrid);

    int checkIsExists(Role Role);

    int insertRole(Role Role);

    int updateRole(Role Role);

    int deleteRole(int usrid);

    List<Role> getRoleByCid(int cid);
}
