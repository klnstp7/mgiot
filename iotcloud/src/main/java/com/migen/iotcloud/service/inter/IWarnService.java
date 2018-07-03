package com.migen.iotcloud.service.inter;

import com.migen.iotcloud.condition.WarnCondition;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.entity.WarnShow;
import com.migen.iotcloud.entity.WarnMonitor;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IWarnService {

    List<WarnShow> queryWarnFirst(int did);

    PageVo<WarnMonitor> findByPaging(WarnCondition condition, int page, int rows);
}
