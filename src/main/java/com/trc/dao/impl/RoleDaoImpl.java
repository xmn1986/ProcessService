package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trc.dao.RoleMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.Role;

@Service("roleDao")
public class RoleDaoImpl extends BaseMapperDaoImpl<Role> implements RoleMapper {

	private static final long serialVersionUID = 3413046951354753633L;
	
	private static final String SELECT_MAX_ACTIVITI_GROUP_ID = ".selectMaxActivitiGroupId";
	
	private static final String SELECT_ACTIVITI_GROUP_ID = ".selectActivitiGroupId";

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Role record)  throws Exception{
		return super.insertBean(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int batchInsert(List<Role> roles) throws SQLException{
		return super.batchInsert(roles);
	}

	@Override
	public List<Role> select(Map<String, Object> param) throws Exception {
		return super.find(param);
	}

	@Override
	public Map<String,String> selectMaxActivitiGroupId(String roleId) throws Exception {
		return (Map<String,String>)sqlSessionTemplate2.selectOne(getSqlId(SELECT_MAX_ACTIVITI_GROUP_ID), roleId) ;
	}

	@Override
	public List<Role> selectActivitiGroupId(List<String> roleIds)
			throws Exception {
		return sqlSessionTemplate2.selectList(getSqlId(SELECT_ACTIVITI_GROUP_ID), roleIds);
	}

}
