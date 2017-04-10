package com.trc.dao;

import com.trc.model.ActReModel;

public interface ActReModelMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActReModel record);

    int insertSelective(ActReModel record);

    ActReModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActReModel record);

    int updateByPrimaryKey(ActReModel record);
}