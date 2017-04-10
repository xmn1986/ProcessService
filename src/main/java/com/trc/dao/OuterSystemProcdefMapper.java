package com.trc.dao;

import java.sql.SQLException;

import com.trc.model.OuterSystemProcdef;
import com.trc.util.Pagination;

public interface OuterSystemProcdefMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OuterSystemProcdef record);

    int insertSelective(OuterSystemProcdef record);

    OuterSystemProcdef selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OuterSystemProcdef record);

    int updateByPrimaryKey(OuterSystemProcdef record);
    
    Pagination<OuterSystemProcdef> pagination(Pagination<OuterSystemProcdef> form) throws SQLException;
    
}