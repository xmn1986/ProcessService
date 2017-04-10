package com.trc.acitiviti.event;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.trc.biz.TaskBiz;
import com.trc.util.CommonUtil;

public class EmployeApplyListener implements TaskListener {

	private Log log = LogFactory.getLog(EmployeApplyListener.class);
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	@Autowired
	private TaskBiz taskBiz;
	
	@Override
	public void notify(DelegateTask arg0) {
		try {
			arg0.setVariable("employeeFlag", true);
			/*taskBiz.saveEmployeeApplyTaskInfo(arg0.getVariable("outerSysNo")
					.toString(), arg0.getVariable("taskId").toString(), arg0
					.getVariable("serviceType").toString(),
					arg0.getVariable("parameter").toString());*/
		} catch (Exception e) {
			log.error(CommonUtil.joinStr("执行工作流程任务[taskId=",arg0.getId(),"]的监听事件异常").toString(), e);
		}
	}

}
