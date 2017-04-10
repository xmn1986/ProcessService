package com.trc.dao;

import com.trc.model.SystemOperateLog;

public interface SystemOperateLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemOperateLog record);

    int insertSelective(SystemOperateLog record);

    SystemOperateLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemOperateLog record);

    int updateByPrimaryKey(SystemOperateLog record);
}