package com.trc.dao;

import java.sql.SQLException;

import com.trc.model.TaskInfo;

public interface TaskInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskInfo record);

    int insertSelective(TaskInfo record);

    TaskInfo selectByPrimaryKey(Long id) throws SQLException;

    int updateByPrimaryKeySelective(TaskInfo record);

    int updateByPrimaryKey(TaskInfo record);
}