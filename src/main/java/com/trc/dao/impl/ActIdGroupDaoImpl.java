package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trc.dao.ActIdGroupMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActIdGroup;

@Service("actIdGroupDao")
public class ActIdGroupDaoImpl extends BaseMapperDaoImpl<ActIdGroup> implements ActIdGroupMapper {

	private static final long serialVersionUID = 1455818649747226413L;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ActIdGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ActIdGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActIdGroup selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ActIdGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ActIdGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<ActIdGroup>  getAll() throws SQLException {
		return super.getAll();
	}
	
	@Override
	public int batchInsert(List<ActIdGroup> actIdGroups) throws SQLException{
		return super.batchInsert(actIdGroups);
	}
	
}
