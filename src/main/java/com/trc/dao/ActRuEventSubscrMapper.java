package com.trc.dao;

import com.trc.model.ActRuEventSubscr;

public interface ActRuEventSubscrMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActRuEventSubscr record);

    int insertSelective(ActRuEventSubscr record);

    ActRuEventSubscr selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActRuEventSubscr record);

    int updateByPrimaryKey(ActRuEventSubscr record);
}