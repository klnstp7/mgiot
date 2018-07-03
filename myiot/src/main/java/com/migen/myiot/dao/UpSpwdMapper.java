package com.migen.myiot.dao;

import com.migen.myiot.entity.UpSpwd;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface UpSpwdMapper {

    int insertUpSpwd(UpSpwd upspwd);

}
