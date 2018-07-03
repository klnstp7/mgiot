package com.migen.iotcloud.condition;

import com.migen.iotcloud.entity.BaseRowBound;

/**
 * Created by Lthui on 2017/3/17.
 */
public class CompanyCondition extends BaseRowBound {

    public CompanyCondition(){

    }

    private String company;

    private int ctype;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getctype() {
        return ctype;
    }

    public void setctype(int ctype) {
        this.ctype = ctype ;
    }

}
