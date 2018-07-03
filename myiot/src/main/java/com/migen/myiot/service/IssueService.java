package com.migen.myiot.service;

import com.migen.myiot.dao.IssueMapper;
import com.migen.myiot.entity.Issue;
import com.migen.myiot.utils.SpringContext;

/**
 * Created by Administrator on 2018/6/2.
 */
public  class IssueService {

    static IssueMapper issueMapper= SpringContext.getSqlSession().getMapper(IssueMapper.class);

    public  static  int getActiveCountBydid(int did){
        return issueMapper.getActiveCountBydid(did);
    }

    public static int insertIssue(Issue issue){
        return issueMapper.insertIssue(issue);
    }

    public static int updateIssue(Issue issue){
        return issueMapper.updateIssue(issue);
    }

}
