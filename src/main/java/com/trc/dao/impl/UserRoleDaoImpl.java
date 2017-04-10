package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trc.dao.UserRoleMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.UserRole;

@Service("userRoleDao")
public class UserRoleDaoImpl extends BaseMapperDaoImpl<UserRole> implements UserRoleMapper {

	private static final long serialVersionUID = -6556621480489359871L;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UserRole record)  throws SQLException{
		return super.insertBean(record);
	}

	@Override
	public int insertSelective(UserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserRole selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchInsert(List<UserRole> userRoles) throws SQLException{
		return super.batchInsert(userRoles);
	}

	@Override
	public List<UserRole> select(Map<String, Object> param) throws Exception {
		return super.find(param);
	}
	
	@Override
	public int delete(Map<String, Object> param) throws SQLException{
		return super.delete(param);
	}

}
