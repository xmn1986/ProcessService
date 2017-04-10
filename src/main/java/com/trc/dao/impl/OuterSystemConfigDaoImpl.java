package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.trc.dao.OuterSystemConfigMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.ActReProcdef;
import com.trc.model.OuterSystemConfig;
import com.trc.util.Pagination;

@Service("outerSystemConfigDao")
public class OuterSystemConfigDaoImpl extends BaseMapperDaoImpl<OuterSystemConfig> implements OuterSystemConfigMapper {

	private static final long serialVersionUID = -7152236681444157362L;
	
	private static final String SELECT_ALL_OUTER_SYS = ".selectAllOuterSys";

	@Override
	public int insert(OuterSystemConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(OuterSystemConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(OuterSystemConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(OuterSystemConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Pagination<OuterSystemConfig> pagination(Pagination<OuterSystemConfig> form) throws SQLException{
		return super.pagination(form);
	}

	@Override
	public List<Map<String, String>> selectAllOuterSys() {
		return sqlSessionTemplate2.selectList(getSqlId(SELECT_ALL_OUTER_SYS));
	}


}
