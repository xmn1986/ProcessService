package com.trc.dao;

import com.trc.model.ActRuIdentitylink;

public interface ActRuIdentitylinkMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActRuIdentitylink record);

    int insertSelective(ActRuIdentitylink record);

    ActRuIdentitylink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActRuIdentitylink record);

    int updateByPrimaryKey(ActRuIdentitylink record);
}