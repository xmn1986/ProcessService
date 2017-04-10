package com.trc.dao;

import com.trc.model.DictType;

public interface DictTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictType record);

    int insertSelective(DictType record);

    DictType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DictType record);

    int updateByPrimaryKey(DictType record);
}