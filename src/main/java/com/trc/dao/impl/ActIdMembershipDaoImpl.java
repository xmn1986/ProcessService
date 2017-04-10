package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trc.dao.ActIdMembershipMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActIdMembership;

@Service("actIdMembershipDao")
public class ActIdMembershipDaoImpl extends BaseMapperDaoImpl<ActIdMembership> implements ActIdMembershipMapper {

	private static final long serialVersionUID = -2090360989953945021L;

	@Override
	public int deleteByPrimaryKey(ActIdMembership key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ActIdMembership record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ActIdMembership record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int batchInsert(List<ActIdMembership> actIdMemberships) throws SQLException{
		return super.batchInsert(actIdMemberships);
	}
	
	@Override
	public int delete(Map<String, Object> param) throws SQLException{
		return super.delete(param);
	}
	

	
	

}
