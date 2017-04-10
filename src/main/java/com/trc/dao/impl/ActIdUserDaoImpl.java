package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.trc.dao.ActIdUserMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActIdUser;

@Service("actIdUserDao")
public class ActIdUserDaoImpl extends BaseMapperDaoImpl<ActIdUser> implements ActIdUserMapper{

	private static final long serialVersionUID = 1866765739891541652L;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ActIdUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ActIdUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActIdUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ActIdUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ActIdUser record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int batchInsert(List<ActIdUser> actIdUsers) throws SQLException{
		return super.batchInsert(actIdUsers);
	}

	@Override
	public ActIdUser selectLoginUser(String username, String pwd) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("pwd", pwd);
		List<ActIdUser> list = sqlSessionTemplate2.selectList(getSqlId(".selectLoginUser"), map);
		if(CollectionUtils.isEmpty(list))
			return null;
		return list.get(0);
	}

	
	
}
