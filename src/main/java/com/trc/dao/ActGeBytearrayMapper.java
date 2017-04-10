package com.trc.dao;

import com.trc.model.ActGeBytearray;

public interface ActGeBytearrayMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActGeBytearray record);

    int insertSelective(ActGeBytearray record);

    ActGeBytearray selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActGeBytearray record);

    int updateByPrimaryKeyWithBLOBs(ActGeBytearray record);

    int updateByPrimaryKey(ActGeBytearray record);
}