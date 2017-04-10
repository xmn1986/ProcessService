package com.trc.dao;

import com.trc.model.ActIdInfo;

public interface ActIdInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActIdInfo record);

    int insertSelective(ActIdInfo record);

    ActIdInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActIdInfo record);

    int updateByPrimaryKeyWithBLOBs(ActIdInfo record);

    int updateByPrimaryKey(ActIdInfo record);
}