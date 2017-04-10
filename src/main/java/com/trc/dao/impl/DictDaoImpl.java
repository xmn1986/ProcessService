package com.trc.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trc.dao.DictMapper;
import com.trc.dao.util.BaseMapperDaoImpl;
import com.trc.model.Dict;

@Service("dictDao")
public class DictDaoImpl extends BaseMapperDaoImpl<Dict> implements DictMapper {

	private static final long serialVersionUID = -2915411520547774601L;
	
	private static final String SELECT_OUTER_SYS_DICT = ".selectOuterSysDict";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Dict record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Dict record) {
		return 0;
	}

	@Override
	public Dict selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Dict record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Dict record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Dict> selectOuterSysDict(String outerSysNo, String typeNo)
			throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("outerSysNo", outerSysNo);
		map.put("typeNo", typeNo);
		return sqlSessionTemplate2.selectList(getSqlId(SELECT_OUTER_SYS_DICT), map);
	}

	

}
