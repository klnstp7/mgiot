package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.condition.MenuCondition;
import com.migen.iotcloud.dto.MenuDto;
import com.migen.iotcloud.entity.Menu;
import com.migen.iotcloud.dto.PageVo;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IMenuService {

    List<MenuDto> getChildrenByParentId(String parentid, int usrid);

    PageVo<Menu> find(MenuCondition Cond);

    Menu getMenuById(int mid);

    boolean checkIsExists(Menu menu);

    boolean insertMenu(Menu menu);

    boolean updateMenu(Menu menu);

    boolean deleteMenu(int mid);

    //List<Menu> getChildrenByParentId(String parentid);

    List<MenuDto> getMenuByUsrId(int usrid);
}
