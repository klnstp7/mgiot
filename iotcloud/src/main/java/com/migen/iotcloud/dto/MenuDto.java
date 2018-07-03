package com.migen.iotcloud.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fengy
 *
 */
public class MenuDto
{
    private int	   id;
    private String	text;
    private String	iconCls;
    private Integer	   parent_id;
    private String	state;
    private String	url;
    private int	   mtype;
    private String	dt;

    public int getMtype()
    {
        return mtype;
    }

    public void setMtype(int mtype)
    {
        this.mtype = mtype;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * 自定义属性信息
     */
    private Map<String, Object>	attributes	= new HashMap<String, Object>();

    public MenuDto()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getIconCls()
    {
        return iconCls;
    }

    public void setIconCls(String iconCls)
    {
        this.iconCls = iconCls;
    }

    public Integer getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(Integer parentId)
    {
        parent_id = parentId;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Map<String, Object> getAttributes()
    {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes)
    {
        this.attributes = attributes;
    }

    public String getDt()
    {
        return dt;
    }

    public void setDt(String dt)
    {
        this.dt = dt;
    }

}
