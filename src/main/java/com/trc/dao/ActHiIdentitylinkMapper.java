package com.trc.dao;

import com.trc.model.ActHiIdentitylink;

public interface ActHiIdentitylinkMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiIdentitylink record);

    int insertSelective(ActHiIdentitylink record);

    ActHiIdentitylink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActHiIdentitylink record);

    int updateByPrimaryKey(ActHiIdentitylink record);
}