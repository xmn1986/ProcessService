package com.trc.acitiviti.event;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ApprovalEndEvent implements JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		
		System.out.println("审批完成后工作流业务处理...");

	}

}
