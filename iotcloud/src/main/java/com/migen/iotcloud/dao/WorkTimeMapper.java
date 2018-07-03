package com.migen.iotcloud.dao;

import com.migen.iotcloud.condition.WorkTimeCondition;
import com.migen.iotcloud.entity.WorkTime;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface WorkTimeMapper {

    int countByCond(WorkTimeCondition Cond);

    List<WorkTime> selectByCond(WorkTimeCondition Cond);

    int deleteWorkTime(int did);
}
