package com.migen.iotcloud.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface IssueMapper {

    int deleteIssue(@Param("did")int did);
}
