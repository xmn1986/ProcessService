package com.trc.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trc.biz.UserBiz;
import com.trc.dao.ActIdGroupMapper;

@Service("userBiz")
public class UserBizImpl implements UserBiz {

	@Autowired
	private ActIdGroupMapper actIdGroupDao;
	

}
