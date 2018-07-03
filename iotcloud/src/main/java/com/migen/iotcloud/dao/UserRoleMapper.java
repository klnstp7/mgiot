package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface UserRoleMapper {

    List<UserRole> getRoleByUserId(int usrid);

    List<UserRole> getUserByRid(int rid);

    int insertUserRole(UserRole userRole);

    int deleteUserRoleByUserId(int usrid);

    int deleteUserRoleByRoleId(int rid);
}
