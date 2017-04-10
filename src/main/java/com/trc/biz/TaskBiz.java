package com.trc.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;

import com.trc.model.ProcessTask;
import com.trc.util.Pagination;

public interface TaskBiz {

	/**
	 * 
	* @Title: queryTask 
	* @Description: 根据委派人/候选人查询任务
	* @param @param assingnee 委派人
	* @param @param params 查询参数
	* @param @return    设定文件 
	* @return List<Task>    返回类型 
	* @throws
	 */
	public List<ProcessTask> queryTask(String assingnee,  Map<String, Object> params);
	/**
	 * 
	* @Title: queryCandidateGroupTask 
	* @Description: 根据候选人组查询任务
	* @param @param params
	* @param @return    设定文件 
	* @return List<Task>    返回类型 
	* @throws
	 */
	public List<ProcessTask> queryCandidateGroupTask(Map<String, Object> params);
	/**
	 * 
	* @Title: taskPagination 
	* @Description: 任务分页查询
	* @param @param form
	* @param @return    设定文件 
	* @return Pagination<Task>    返回类型 
	* @throws
	 */
	public Pagination<ProcessTask> taskPagination(Pagination<ProcessTask> form) throws Exception; 
	
	/**
	 * 
	* @Title: completeTask 
	* @Description: 完成任务
	* @param @param taskId    任务ID
	* @return void    返回类型 
	* @throws
	 */
	public void completeTask(String taskId);
	
	/**
	 * 
	* @Title: completeTask 
	* @Description: 完成任务
	* @param @param taskId    任务ID
	* @param @param taskId    参数
	* @return void    返回类型 
	* @throws
	 */
	public void completeTask(String taskId, Map<String, String> param);
	
	/**
	 * 
	* @Title: queryPreExcutedTask 
	* @Description: 查询当前任务前面已经执行的任务
	* @param @param procDefId 流程定义ID
	* @param @param procInstId 当前流程实例ID
	* @param @param taskId 当前任务ID
	* @param @return    设定文件 
	* @return List<Task>    任务列表
	* @throws
	 */
	public List<ProcessTask> queryPreExcutedTask(String procDefId, String procInstId, String taskId);
	
	/**
	 * 
	* @Title: saveEmployeeApplyTaskInfo 
	* @Description: 保存员工申请任务信息
	* @param @param outerSysNo 外部系统编号
	* @param @param taskId 任务ID
	* @param @param serviceType 服务类型:0-http,1-webservice
	* @param @param parameter    调用参数，json格式
	* @return void    返回类型 
	* @throws
	 */
	public void saveEmployeeApplyTaskInfo(String outerSysNo, String taskId, String serviceType, String parameter) throws NumberFormatException, SQLException;
	
}
