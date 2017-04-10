package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.trc.dao.UserInfoMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActIdUser;
import com.trc.model.UserInfo;

@Service("userInfoDao")
public class UserInfoDaoImpl extends BaseMapperDaoImpl<UserInfo> implements UserInfoMapper {

	private static final long serialVersionUID = 1220131941750072015L;
	
	private static final String SELECT_MAX_ACTIVITI_ID = ".selectMaxActivitiId";
	
	private static final String SELECT_ACTIVITI_USER_ID = ".selectActivitiUserId";
	
	private static final String SELECT_LOGIN_USER = ".selectLoginUser";

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UserInfo record)  throws Exception{
		return super.insertBean(record);
	}

	@Override
	public int insertSelective(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfo> select(Map<String, Object> param) throws Exception {
		return super.find(param);
	}
	
	@Override
	public int batchInsert(List<UserInfo> userInfos) throws SQLException{
		return super.batchInsert(userInfos);
	}

	@Override
	public Map<String,String> selectMaxActivitiId(String userName) throws Exception {
		return  (Map<String,String>)sqlSessionTemplate2.selectOne(getSqlId(SELECT_MAX_ACTIVITI_ID), userName) ;
	}
	
	@Override
	public int delete(Map<String, Object> param) throws SQLException{
		return super.delete(param);
	}

	@Override
	public List<UserInfo> selectActivitiUserId(List<String> userId)
			throws Exception {
		return sqlSessionTemplate2.selectList(getSqlId(SELECT_ACTIVITI_USER_ID), userId);
	}

	@Override
	public UserInfo selectLoginUser(String username, String pwd) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("pwd", pwd);
		List<UserInfo> list = sqlSessionTemplate2.selectList(getSqlId(SELECT_LOGIN_USER), map);
		if(CollectionUtils.isEmpty(list))
			return null;
		return list.get(0);
	}

}
