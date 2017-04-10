package com.trc.dao.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.trc.dao.OuterSystemProcdefMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.OuterSystemProcdef;
import com.trc.util.Pagination;

@Service("outerSystemProcdefDao")
public class OuterSystemProcdefDaoImpl extends BaseMapperDaoImpl<OuterSystemProcdef> implements OuterSystemProcdefMapper {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4961113333495563209L;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(OuterSystemProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(OuterSystemProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OuterSystemProcdef selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(OuterSystemProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(OuterSystemProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pagination<OuterSystemProcdef> pagination(
			Pagination<OuterSystemProcdef> form) throws SQLException {
		return super.pagination(form);
	}

}
