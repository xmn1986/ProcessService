package com.trc.acitiviti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyAssignmentHandler implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask arg0) {
		/*arg0.setAssignee("xmn");
		arg0.addCandidateUser("fozzie");
		System.out.println("任务监听MyAssignmentHandler执行中");*/
	}

}
