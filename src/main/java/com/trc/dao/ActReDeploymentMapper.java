package com.trc.dao;

import com.trc.model.ActReDeployment;

public interface ActReDeploymentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActReDeployment record);

    int insertSelective(ActReDeployment record);

    ActReDeployment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActReDeployment record);

    int updateByPrimaryKey(ActReDeployment record);
}