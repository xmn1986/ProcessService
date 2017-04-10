package com.trc.dao;

import com.trc.model.ActHiDetail;

public interface ActHiDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiDetail record);

    int insertSelective(ActHiDetail record);

    ActHiDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActHiDetail record);

    int updateByPrimaryKey(ActHiDetail record);
}