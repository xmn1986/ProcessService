package com.trc.dao;

import com.trc.model.ActRuVariable;

public interface ActRuVariableMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActRuVariable record);

    int insertSelective(ActRuVariable record);

    ActRuVariable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActRuVariable record);

    int updateByPrimaryKey(ActRuVariable record);
}