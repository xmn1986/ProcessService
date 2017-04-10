package com.trc.biz.impl;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trc.biz.ExcuteBiz;

@Service("excuteBiz")
public class ExcuteBizImpl implements ExcuteBiz {

	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	
	@Override
	public void excuteTask() {
		
		//repositoryService.createDeployment().addClasspathResource("process.bpmn").deploy();
		runtimeService.startProcessInstanceByKey("myProcess");
		Task task=taskService.createTaskQuery().singleResult();
        System.out.println("第一个流程任务完成前"+task.getName());
        taskService.complete(task.getId());
        task=taskService.createTaskQuery().singleResult();
        System.out.println("第二个流程任务完成前"+task.getName());
        taskService.complete(task.getId());
        
	}

	@Override
	public void employeApply() {
		Task task=taskService.createTaskQuery().singleResult();
        System.out.println("员工完成申请任务:"+task.getName());
		
	}

	@Override   
	public void officerApproval() {
		
		Task task=taskService.createTaskQuery().singleResult();
        System.out.println("主管完成审批任务:"+task.getName());
		
	}

	@Override
	public void managerApproval() {
		
		Task task=taskService.createTaskQuery().singleResult();
        System.out.println("经理完成审批任务:"+task.getName());
		
	}

}
