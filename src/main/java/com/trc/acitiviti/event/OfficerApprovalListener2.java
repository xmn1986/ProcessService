package com.trc.acitiviti.event;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class OfficerApprovalListener2 implements TaskListener {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -173698548148052844L;

	@Override
	public void notify(DelegateTask arg0) {
		arg0.setVariable("officerFlag2", true);//审批通过
	}

}
