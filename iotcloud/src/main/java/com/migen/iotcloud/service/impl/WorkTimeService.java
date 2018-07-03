package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.condition.WorkTimeCondition;
import com.migen.iotcloud.dao.WorkTimeMapper;
import com.migen.iotcloud.entity.WorkTime;
import com.migen.iotcloud.service.inter.IWorkTimeService;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class WorkTimeService implements IWorkTimeService {

    @Autowired
    WorkTimeMapper workTimeMapper;

    public PageVo<WorkTime> findByPaging(WorkTimeCondition condition , int page, int rows){
        int total=workTimeMapper.countByCond(condition);
        PageVo<WorkTime> pageVo=new PageVo<WorkTime>(total);
        condition.setStart((page-1)*rows);
        condition.setLimit(page * rows);
        List<WorkTime> workTimes=workTimeMapper.selectByCond(condition);
        for(WorkTime item :workTimes){
            item.setStrStartTime(DateUtils.getDateTime(item.getStartTime()));
            item.setStrEndTime(DateUtils.getDateTime(item.getEndTime()));
        }
        pageVo.setRows(workTimes);
        return pageVo;
    }
}
