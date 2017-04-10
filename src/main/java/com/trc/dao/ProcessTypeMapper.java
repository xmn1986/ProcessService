package com.trc.dao;

import com.trc.model.ProcessType;

public interface ProcessTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProcessType record);

    int insertSelective(ProcessType record);

    ProcessType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProcessType record);

    int updateByPrimaryKey(ProcessType record);
}