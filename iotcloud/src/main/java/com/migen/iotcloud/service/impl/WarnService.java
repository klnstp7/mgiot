package com.migen.iotcloud.service.impl;

import com.migen.iotcloud.condition.WarnCondition;
import com.migen.iotcloud.entity.WarnMonitor;
import com.migen.iotcloud.dao.WarnMapper;
import com.migen.iotcloud.dto.PageVo;
import com.migen.iotcloud.entity.Warn;
import com.migen.iotcloud.entity.WarnShow;
import com.migen.iotcloud.service.inter.IWarnService;
import com.migen.iotcloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class WarnService implements IWarnService {

    @Autowired
    private WarnMapper warnMapper;


    public List<WarnShow> queryWarnFirst(int did){
        List<WarnShow> result=new ArrayList<WarnShow>();
        List<Warn> warns=warnMapper.queryWarnFirst(did);
        for (Warn item: warns) {
            WarnShow td = new WarnShow();
            td.setInfo(item.getInfo());
            result.add(td);
        }
        return result;
    }

    /**
     * 查询
     * @param condition
     * @return
     */
    public PageVo<WarnMonitor> findByPaging(WarnCondition condition, int page, int rows){
        //计算记录数
        int total=warnMapper.countByCond(condition);
        PageVo<WarnMonitor> pageVo=new PageVo<WarnMonitor>(total);
        condition.setStart((page-1)*rows);
        condition.setLimit(page * rows);
        List<WarnMonitor> warnMonitors=warnMapper.selectByCond(condition);
        for(WarnMonitor item:warnMonitors){
            item.setStrdt(DateUtils.getDateTime(item.getDt()));
        }
        pageVo.setRows(warnMonitors);
        return pageVo;
    }
}
