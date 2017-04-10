package com.trc.dao;

import com.trc.model.ActHiVarinst;

public interface ActHiVarinstMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiVarinst record);

    int insertSelective(ActHiVarinst record);

    ActHiVarinst selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActHiVarinst record);

    int updateByPrimaryKey(ActHiVarinst record);
}