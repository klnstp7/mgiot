package com.migen.iotcloud.dao;

import com.migen.iotcloud.condition.WarnCondition;
import com.migen.iotcloud.entity.Warn;
import com.migen.iotcloud.entity.WarnMonitor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface WarnMapper {

    List<Warn> queryWarnFirst(int did);

    int countByCond(WarnCondition Cond);

    List<WarnMonitor> selectByCond(WarnCondition Cond);
}
