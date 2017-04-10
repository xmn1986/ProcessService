package com.trc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trc.biz.LeaveBiz;
import com.trc.dao.ActReProcdefMapper;
import com.trc.model.ActReProcdef;

@Service("LeaveBiz")
public class LeaveBizImpl implements LeaveBiz {
	
	@Autowired
	private ActReProcdefMapper actReProcdefDao;
	
	@Override
	public void excuteTask() {
		System.out.println("@@@@@@@@");
        
	}

	@Override
	public void employeApply() {
		
		System.out.println("员工申请业务处理");
		
	}

	@Override
	public void officerApproval() {
		
		System.out.println("主管审批业务处理");
		
	}

	@Override
	public void managerApproval() {
		
		System.out.println("经理审批业务处理");
		
	}

	@Override
	public List<ActReProcdef> queryList() {
		return actReProcdefDao.queryList();
	}

}
