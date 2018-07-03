package com.migen.iotcloud.dao;

import com.migen.iotcloud.condition.MenuCondition;
import com.migen.iotcloud.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface MenuMapper {

    List<Menu> getAll();

    int countByCond(MenuCondition Cond);

    List<Menu> selectByCond(MenuCondition Cond);

    Menu getMenuById(int mid);

    int checkIsExists(Menu menu);

    int insertMenu(Menu menu);

    int updateMenu(Menu menu);

    int deleteMenu(int mid);

    List<Menu> getChildrenByParentId(@Param("parentid") String parentid,@Param("usrid")int usrid);

    List<Menu> getMenuByUsrId(int usrid);
}
