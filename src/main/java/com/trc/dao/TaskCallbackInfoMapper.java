package com.trc.dao;

import com.trc.model.TaskCallbackInfo;

public interface TaskCallbackInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskCallbackInfo record);

    int insertSelective(TaskCallbackInfo record);

    TaskCallbackInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskCallbackInfo record);

    int updateByPrimaryKey(TaskCallbackInfo record);
}