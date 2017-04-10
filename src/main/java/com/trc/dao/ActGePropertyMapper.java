package com.trc.dao;

import com.trc.model.ActGeProperty;

public interface ActGePropertyMapper {
    int deleteByPrimaryKey(String name);

    int insert(ActGeProperty record);

    int insertSelective(ActGeProperty record);

    ActGeProperty selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(ActGeProperty record);

    int updateByPrimaryKey(ActGeProperty record);
}