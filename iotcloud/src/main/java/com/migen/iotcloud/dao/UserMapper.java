package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.User;
import com.migen.iotcloud.condition.UserCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface UserMapper {

    User getUserByPwd(User user);

    int updatePassWord(User user);

    int countByCond(UserCondition Cond);

    List<User> selectByCond(UserCondition Cond);

    User getUserById(int usrid);

    int checkIsExists(User user);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int usrid);

    List<User> getUserByCid(int cid);
}
