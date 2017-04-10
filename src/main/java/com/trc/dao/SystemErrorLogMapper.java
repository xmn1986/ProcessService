package com.trc.dao;

import com.trc.model.SystemErrorLog;

public interface SystemErrorLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemErrorLog record);

    int insertSelective(SystemErrorLog record);

    SystemErrorLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemErrorLog record);

    int updateByPrimaryKey(SystemErrorLog record);
}