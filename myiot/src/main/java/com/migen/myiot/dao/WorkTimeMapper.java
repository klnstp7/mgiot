package com.migen.myiot.dao;

import com.migen.myiot.entity.WorkTime;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface WorkTimeMapper {

    int insertWorkTime(WorkTime workTime);

    int updateWorkTime(WorkTime workTime);
}
