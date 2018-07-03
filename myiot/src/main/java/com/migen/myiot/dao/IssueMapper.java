package com.migen.myiot.dao;

import com.migen.myiot.entity.Issue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface IssueMapper {

    int getActiveCountBydid(@Param("did")int did);

    int insertIssue(Issue issue);

    int updateIssue(Issue issue);

}
