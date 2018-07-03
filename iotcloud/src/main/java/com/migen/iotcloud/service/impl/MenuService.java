package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.condition.MenuCondition;
import com.migen.iotcloud.dao.MenuMapper;
import com.migen.iotcloud.dao.RolePriMapper;
import com.migen.iotcloud.dto.MenuDto;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.entity.Menu;
import com.migen.iotcloud.service.inter.IMenuService;
import com.migen.iotcloud.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RolePriMapper rolePriMapper;

    /**
     * 根据父Id查找节点
     * @param parentid
     * @param usrid
     * @return
     */
    public List<MenuDto> getChildrenByParentId(String parentid, int usrid){
        List<MenuDto> menuDtoList=new LinkedList<MenuDto>();
        List<Menu> menuAllList=menuMapper.getMenuByUsrId(usrid);
        List<Menu> menuList=menuMapper.getChildrenByParentId(parentid,usrid);
        for(Menu menu :menuList){
            MenuDto td = new MenuDto();
            td.setId(menu.getMid());
            td.setText(menu.getMname());
            td.setIconCls(menu.getIcon());
            td.setParent_id(menu.getParentid());
            td.setUrl(menu.getUrl());
            boolean hasChild=hasChilds(menuAllList,menu.getMid());
            if (hasChild)
            {
                td.setState("closed");
            }
            else
            {
                td.setState("open");
            }
            menuDtoList.add(td);
        }
        return menuDtoList;
    }

    /**
     * 在数据库查询出用户能访问有列表
     */
    public  List<MenuDto> selectMenu(String priStr, List<MenuDto> treeDTOS){
        String code = "\\,";
        String[] rt = Utils.splitStr(priStr, code);
        List<MenuDto> lt = new ArrayList<MenuDto>();
        if (!Utils.emptyArgs(rt))
        {
            for (int i = 0; i < rt.length; i++)
            {
                String rti = rt[i];
                if (!Utils.emptyStr(rti))
                {
                    int curId = Integer.parseInt(rti);
                    //Utils.logSys("00curId = " + curId);
                    for (int j = 0; j < treeDTOS.size(); j++)
                    {
                        MenuDto to = treeDTOS.get(j);
                        if (to.getId() == curId)
                        {
                            //Utils.logSys("11curId = " + curId);
                            lt.add(to);
                            break;
                        }
                    }
                }
            }
        }
        return lt;
    }


    public PageVo<Menu> find(MenuCondition Cond){
        int total=menuMapper.countByCond(Cond);
        List<Menu> menuList=menuMapper.selectByCond(Cond);
        for(Menu menu :menuList){
            menu.set_parentId(menu.getParentid());
            if(menu.getParentid()!=null){
                Menu parentMenu=menuMapper.getMenuById(menu.getParentid());
                String menuName=parentMenu.getMname();
                menu.setParentname(menuName);
            }
        }
        PageVo<Menu> pageVo=new PageVo<Menu>(total);
        pageVo.setRows(menuList);
        return pageVo;
    }

    public Menu getMenuById(int mid){
        Menu menu=menuMapper.getMenuById(mid);
        if(menu.getParentid()!=null){
            String menuName=menuMapper.getMenuById(menu.getParentid()).getMname();
            menu.setParentname(menuName);
        }
        return menu;
    }

    public boolean checkIsExists(Menu menu){
        return menuMapper.checkIsExists(menu)>0;
    }

    public boolean insertMenu(Menu menu){
        menu.setDt(new Date());
        return menuMapper.insertMenu(menu)>0;
    }

    public boolean updateMenu(Menu menu){
        return menuMapper.updateMenu(menu)>0;
    }

    public boolean deleteMenu (int mid){
        //菜单对应的权限
        rolePriMapper.deletePriByMid(mid);

        //菜单
        List<Menu> menuList=getMenuChildList(mid);
        for (Menu menu:menuList){
            menuMapper.deleteMenu(menu.getMid());
        }
        return true;
    }

    public List<Menu> getMenuChildList(int pid){
        List<Menu> childs = new ArrayList<Menu>();
        Menu menu=getMenuById(pid);
        childs.add(menu);
        List<Menu> menuList=menuMapper.getAll();
        if (hasChilds(menuList, pid)) {
            childs = getChildList(menuList,pid,childs);
        }
        return childs;
    }

    /**
     * 获取父id下的子集合
     * @param list
     * @param pId
     * @param reList
     * @return
     */
    private  List<Menu> getChildList(List<Menu> list,int pId,List<Menu> reList) {
        for (Menu menu : list) {
            if (menu.getParentid()!=null) {
                if (menu.getParentid().equals(pId)) {//查询下级菜单
                    reList.add(menu);
                    if (hasChilds(list, menu.getMid())) {
                        getChildList(list, menu.getMid(), reList);
                    }
                }
            }
        }
        return reList;
    }

    /**
     * 判断是否含有子节点
     * @param list
     * @param pId
     * @return
     */
    private  boolean hasChilds(List<Menu> list,int pId) {
        boolean flag = false;
        for (Menu menu : list) {
            if (menu.getParentid()!=null) {
                if (menu.getParentid().equals(pId)) {
                    flag=true;
                    break;
                }
            }

        }
        return flag;
    }

    /**
     * 用户菜单
     * @param usrid
     * @return
     */
    public List<MenuDto> getMenuByUsrId(int usrid){
        List<MenuDto> menuDtoList=new LinkedList<MenuDto>();
        List<Menu> menuList=menuMapper.getMenuByUsrId(usrid);
        for(Menu menu :menuList){
            MenuDto td = new MenuDto();
            td.setId(menu.getMid());
            td.setText(menu.getMname());
            td.setIconCls(menu.getIcon());
            td.setParent_id(menu.getParentid());
            td.setUrl(menu.getUrl());
            boolean hasChild=hasChilds(menuList,menu.getMid());
            if (hasChild)
            {
                td.setState("closed");
            }
            else
            {
                td.setState("open");
            }
            menuDtoList.add(td);
        }
        return menuDtoList;
    }

}
