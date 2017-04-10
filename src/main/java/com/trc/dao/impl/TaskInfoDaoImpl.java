package com.trc.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.trc.dao.TaskInfoMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.TaskInfo;

@Service("taskInfoDao")
public class TaskInfoDaoImpl extends BaseMapperDaoImpl<TaskInfo> implements TaskInfoMapper, Serializable {

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TaskInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TaskInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TaskInfo selectByPrimaryKey(Long id) throws SQLException {
		return super.findById(id.toString());
	}

	@Override
	public int updateByPrimaryKeySelective(TaskInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TaskInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
