package com.trc.model;

import java.util.Date;

import org.activiti.engine.task.DelegationState;

public class ProcessTask {
	/**
	 * 任务ID
	 */
	private String taskId;
	/**
	 * 流程定义ID
	 */
	private String processDefinitionId;
	/**
	 * 流程实例ID
	 */
	private String processInstanceId;
	/**
	 * 任务定义Key
	 */
	private String taskDefinitionKey;
	/**
	 * 任务类别
	 */
	private String category;
	/**
	 * 任务名称
	 */
	private String name;
	/**
	 * 任务描述
	 */
	private String description;
	/**
	 * 任务所有者
	 */
	private String owner;
	/**
	 * 任务委派人
	 */
	private String assignee;
	/**
	 * 任务执行ID
	 */
	private String executionId;
	/**
	 * 任务创建时间
	 */
	private Date createTime;
	/**
	 * 任务目标日期
	 */
	private Date dueDate;
	/**
	 * 代理状态
	 */
	private DelegationState delegationState;
	/**
	 * 挂起状态
	 */
	private boolean suspended;
	/**
	 * 父类任务ID
	 */
	private String parentTaskId;
	/**
	 * tenantId
	 */
	private String tenantId;
	/**
	 * 
	 */
	private String formKey;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getTaskDefinitionKey() {
		return taskDefinitionKey;
	}
	public void setTaskDefinitionKey(String taskDefinitionKey) {
		this.taskDefinitionKey = taskDefinitionKey;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public DelegationState getDelegationState() {
		return delegationState;
	}
	public void setDelegationState(DelegationState delegationState) {
		this.delegationState = delegationState;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	
}
