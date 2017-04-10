package com.trc.dao;

import com.trc.model.ActProcdefInfo;

public interface ActProcdefInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActProcdefInfo record);

    int insertSelective(ActProcdefInfo record);

    ActProcdefInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActProcdefInfo record);

    int updateByPrimaryKey(ActProcdefInfo record);
}