package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.condition.WorkTimeCondition;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.entity.WorkTime;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IWorkTimeService {

    PageVo<WorkTime> findByPaging(WorkTimeCondition condition, int page, int rows);
}
