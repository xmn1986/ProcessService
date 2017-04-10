package com.trc.dao;

import com.trc.model.ActRuJob;

public interface ActRuJobMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActRuJob record);

    int insertSelective(ActRuJob record);

    ActRuJob selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActRuJob record);

    int updateByPrimaryKey(ActRuJob record);
}