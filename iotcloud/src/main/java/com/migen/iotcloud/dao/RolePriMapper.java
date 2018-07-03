package com.migen.iotcloud.dao;

import com.migen.iotcloud.entity.RolePri;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface RolePriMapper {

    List<RolePri> getPriByRoleId(int rid);

    int insertRolePri(RolePri rolePri);

    int deletePriByMid(int rid);

    int deletePriByRid(int rid);

}
