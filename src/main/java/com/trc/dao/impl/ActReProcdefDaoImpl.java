package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trc.dao.ActReProcdefMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActReProcdef;
import com.trc.util.Pagination;

@Service("actReProcdefDao")
public class ActReProcdefDaoImpl extends BaseMapperDaoImpl<ActReProcdef> implements ActReProcdefMapper{

	private static final long serialVersionUID = 5324795983405495963L;
	
	private static final String SELECT_ALL_PROC_DEF = ".selectAllProcDef";
	
	public List<ActReProcdef> queryList() {
		try {
			return super.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ActReProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ActReProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActReProcdef selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ActReProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ActReProcdef record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pagination<ActReProcdef> pagination(Pagination<ActReProcdef> form) throws SQLException {
		return super.pagination(form);
	}

	@Override
	public List<Map<String, String>> selectAllProcDef() throws SQLException {
		return sqlSessionTemplate2.selectList(getSqlId(SELECT_ALL_PROC_DEF));
	}

	

}
