package com.trc.dao;

import com.trc.model.ActRuExecution;

public interface ActRuExecutionMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActRuExecution record);

    int insertSelective(ActRuExecution record);

    ActRuExecution selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActRuExecution record);

    int updateByPrimaryKey(ActRuExecution record);
}