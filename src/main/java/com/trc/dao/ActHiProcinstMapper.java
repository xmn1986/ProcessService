package com.trc.dao;

import com.trc.model.ActHiProcinst;

public interface ActHiProcinstMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiProcinst record);

    int insertSelective(ActHiProcinst record);

    ActHiProcinst selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActHiProcinst record);

    int updateByPrimaryKey(ActHiProcinst record);
}