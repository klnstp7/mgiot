package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.entity.User;
import com.migen.iotcloud.condition.UserCondition;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.dto.UserInfo;
import com.migen.iotcloud.dto.UserRoleDto;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IUserService {

    User getUserByPwd(String loginName, String password);

    int updatePassWord(UserInfo userInfo);

    PageVo<User> findByPaging(UserCondition condition, int page, int rows);

    User getUserById(int usrid);

    boolean checkIsExists(User user);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int usrid);

    List<UserRoleDto> getUserRole(int cid, int usrid);

    void saveUserRoles(int usrid,int[] rids);
}
