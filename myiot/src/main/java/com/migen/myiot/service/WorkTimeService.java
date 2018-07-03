package com.migen.myiot.service;

import com.migen.myiot.dao.WorkTimeMapper;
import com.migen.myiot.entity.WorkTime;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class WorkTimeService {

    static WorkTimeMapper workTimeMapper= SpringContext.getSqlSession().getMapper(WorkTimeMapper.class);

    public static int insertWorkTime(WorkTime workTime){
        return workTimeMapper.insertWorkTime(workTime);
    }

   public static int updateWorkTime(WorkTime workTime){
        return  workTimeMapper.updateWorkTime(workTime);
   }

}
