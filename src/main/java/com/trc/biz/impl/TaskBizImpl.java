package com.trc.biz.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.trc.biz.TaskBiz;
import com.trc.dao.ActHiTaskinstMapper;
import com.trc.dao.TaskInfoMapper;
import com.trc.dao.UserInfoMapper;
import com.trc.enums.TaskStatusEnum;
import com.trc.exception.DataException;
import com.trc.form.TaskFrom;
import com.trc.model.ActHiTaskinst;
import com.trc.model.ProcessTask;
import com.trc.model.TaskInfo;
import com.trc.model.UserInfo;
import com.trc.util.CommonUtil;
import com.trc.util.Pagination;

@Service("taskBiz")
public class TaskBizImpl implements TaskBiz, Serializable {
	private static final long serialVersionUID = -6298364037647328018L;
	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskInfoMapper taskInfoDao;
	@Autowired
	private ActHiTaskinstMapper actHiTaskinstDao;
	@Autowired
	private UserInfoMapper userInfoDao;
	
	@Override
	public List<ProcessTask> queryTask(String assingnee, Map<String, Object> params) {
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.taskCandidateOrAssigned(assingnee);
		if(params.containsKey("processDefinitionKeys")){
			String processDefinitionKeys = (String)params.get("processDefinitionKeys");
			List<String> list = new ArrayList<String>();
			for(String s : processDefinitionKeys.split(",")){
				list.add(s);
			}
			taskQuery.processDefinitionKeyIn(list);
		}
		return CommonUtil.getProcessTasks(taskQuery.list());
	}
	
	@Override
	public List<ProcessTask> queryCandidateGroupTask(Map<String, Object> params) {
		TaskQuery taskQuery = taskService.createTaskQuery();
		List<String> candidateGroupList = new ArrayList<String>();
		for(String s : ((String)params.get("candidateGroup")).split(",")){
			candidateGroupList.add(s);
		}
		taskQuery.taskCandidateGroupIn(candidateGroupList);
		if(params.containsKey("processDefinitionKeys")){
			String processDefinitionKeys = (String)params.get("processDefinitionKeys");
			List<String> list = new ArrayList<String>();
			for(String s : processDefinitionKeys.split(",")){
				list.add(s);
			}
			taskQuery.processDefinitionKeyIn(list);
		}
		return CommonUtil.getProcessTasks(taskQuery.list());
	}
	
	@Override
	public Pagination<ProcessTask> taskPagination(Pagination<ProcessTask> form) throws Exception {
		TaskFrom taskForm = (TaskFrom) form;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("outerSysNo", taskForm.getOuterSysNo());
		param.put("id", taskForm.getAssignee());
		List<UserInfo> userInfos = userInfoDao.select(param);
		if(CollectionUtils.isEmpty(userInfos))
			throw new DataException(CommonUtil.joinStr("第三方系统[outerSysNo=",taskForm.getOuterSysNo(),"]用户[id=",taskForm.getAssignee(),"]的信息在用户信息表UserInfo里面查询不到").toString());
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.taskCandidateOrAssigned(userInfos.get(0).getActivitiUserId());
		form.setCount((int)taskQuery.count());
		taskQuery.orderByTaskCreateTime().desc();
		List<Task> taskList = taskQuery.listPage(taskForm.getStart(), taskForm.getLimit());
		form.setDatas(CommonUtil.getProcessTasks(taskList));
		return form;
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

	@Override
	public List<ProcessTask> queryPreExcutedTask(String procDefId, String procInstId,
			String taskId) {
		
		return null;
	}

	@Override
	public void completeTask(String taskId, Map<String, String> param) {
		taskService.complete(taskId, (Map)param);
	}

	@Override
	public void saveEmployeeApplyTaskInfo(String outerSysNo, String taskId, String serviceType,
			String parameter) throws NumberFormatException, SQLException {
		ActHiTaskinst actHiTaskinst = actHiTaskinstDao.selectByPrimaryKey(taskId);
		if(null == actHiTaskinst)
			throw new DataException(CommonUtil.joinStr("查询任务",taskId,"的activiti历史信息为空").toString());
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setOuterSysNo(outerSysNo);
		taskInfo.setTaskId(taskId);
		taskInfo.setParameter(parameter);
		taskInfo.setProcInstId(actHiTaskinst.getProcInstId());
		taskInfo.setTaskName(actHiTaskinst.getName());
		taskInfo.setServiceType(serviceType);
		taskInfo.setStatus(TaskStatusEnum.WAITING.getCode());//等待执行
		taskInfo.setLastModifyTime(new Date());
		taskInfoDao.insert(taskInfo);
	}

}
