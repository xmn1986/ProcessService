package com.trc.biz.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trc.biz.SystemBiz;
import com.trc.constant.Constant;
import com.trc.dao.ActIdUserMapper;
import com.trc.dao.ActReProcdefMapper;
import com.trc.dao.DictMapper;
import com.trc.dao.OuterSystemConfigMapper;
import com.trc.dao.OuterSystemProcdefMapper;
import com.trc.dao.UserInfoMapper;
import com.trc.model.ActIdUser;
import com.trc.model.Dict;
import com.trc.model.OuterSystemConfig;
import com.trc.model.OuterSystemProcdef;
import com.trc.model.UserInfo;
import com.trc.util.Pagination;

@Service("SystemBiz")
public class SystemBizImpl implements SystemBiz {

	@Autowired
	private ActIdUserMapper actIdUserDao;
	@Autowired
	private OuterSystemConfigMapper outerSystemConfigDao;
	@Autowired
	private OuterSystemProcdefMapper outerSystemProcdefDao;
	@Autowired
	private ActReProcdefMapper actReProcdefDao;
	@Autowired
	private DictMapper dictDao;
	@Autowired
	private UserInfoMapper userInfoDao;
	
	@Override
	public UserInfo login(String username, String pwd) throws Exception {
		return userInfoDao.selectLoginUser(username, pwd);
	}

	@Override
	public Pagination<OuterSystemConfig> outerSystemConfigPagination(
			Pagination<OuterSystemConfig> form) throws Exception {
		return outerSystemConfigDao.pagination(form);
	}

	@Override
	public List<Map<String, String>> selectAllOuterSys() {
		return outerSystemConfigDao.selectAllOuterSys();
	}

	@Override
	public Pagination<OuterSystemProcdef> outerSystemProcdefPagination(
			Pagination<OuterSystemProcdef> form) throws Exception {
		return outerSystemProcdefDao.pagination(form);
	}

	@Override
	public List<Map<String, String>> selectAllProcDef() throws Exception {
		return actReProcdefDao.selectAllProcDef();
	}

	@Override
	public List<Dict> selectProcessType(String outerSysNo) throws Exception {
		return dictDao.selectOuterSysDict(outerSysNo, Constant.DICT_TYPE_PROCESS_TYPE);
	}
	

}
