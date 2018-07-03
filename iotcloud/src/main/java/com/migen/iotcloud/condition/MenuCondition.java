package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

/**
 * Created by Lthui on 2017/3/17.
 */
public class MenuCondition extends BaseRowBound {

    public MenuCondition(){

    }

    private boolean visible;

    private int mtype;

    public boolean getVisible()
    {
        return visible;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    public int getMtype()
    {
        return mtype;
    }

    public void setMtype(int mtype)
    {
        this.mtype = mtype;
    }

}
