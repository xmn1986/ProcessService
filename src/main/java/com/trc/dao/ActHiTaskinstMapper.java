package com.trc.dao;

import java.sql.SQLException;

import com.trc.model.ActHiTaskinst;

public interface ActHiTaskinstMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiTaskinst record);

    int insertSelective(ActHiTaskinst record);

    ActHiTaskinst selectByPrimaryKey(String id)  throws SQLException;

    int updateByPrimaryKeySelective(ActHiTaskinst record);

    int updateByPrimaryKey(ActHiTaskinst record);
}