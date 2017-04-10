package com.trc.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.trc.dao.ActHiTaskinstMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActHiTaskinst;

@Service("actHiTaskinstDao")
public class ActHiTaskinstDaoImpl extends BaseMapperDaoImpl<ActHiTaskinst> implements ActHiTaskinstMapper, Serializable {

	private static final long serialVersionUID = -4089190990889134282L;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ActHiTaskinst record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ActHiTaskinst record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActHiTaskinst selectByPrimaryKey(String id) throws SQLException {
		return super.findById(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ActHiTaskinst record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ActHiTaskinst record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
