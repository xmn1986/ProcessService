package com.trc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trc.biz.ProcessBiz;
import com.trc.biz.TaskBiz;
import com.trc.form.TaskFrom;
import com.trc.model.ProcessTask;
import com.trc.util.AppResult;
import com.trc.util.CommonUtil;
import com.trc.util.Pagination;
import com.trc.util.ResultUtil;
import com.trc.util.ValidateUtil;

@Controller
@RequestMapping("/services")
public class FacadeController {

	private static Log log = LogFactory.getLog(ProcessController.class);
	
	@Autowired
	private ProcessBiz processBiz;
	@Autowired
	private TaskBiz taskBiz;
	
	@RequestMapping("/start")
	@ResponseBody
	public AppResult start(HttpServletRequest request, ModelMap modelMap) throws Exception{
		ValidateUtil.paramNullCheck2(request, "outerSysNo:外部系统编号", "processDefKey:流程定义key");
		Map<String, Object> params = CommonUtil.getRequestParam(request);
		JSONObject result = processBiz.updateAndStartProcess(request, params.get("processDefKey").toString(), params);
		return ResultUtil.createSucssAppResult(result);
	}
	
	@RequestMapping("/taskPagination")
	@ResponseBody
	public AppResult taskPagination(TaskFrom form, ModelMap modelMap){
		ValidateUtil.paramNullCheck2(form, "outerSysNo:外部系统编号", "assignee:委派人");
		Pagination<ProcessTask> pagination = null;
	    try {
	      pagination = taskBiz.taskPagination(form);
	    } catch (Exception e) {
	      log.warn("分页查询异常", e);
	      pagination = new Pagination<ProcessTask>();
	    }
	    return ResultUtil.createSucssAppResult(pagination);
	}
	
	@RequestMapping("/completeTask")
	@ResponseBody
	public AppResult completeTask(HttpServletRequest request, ModelMap modelMap){
		ValidateUtil.paramNullCheck2(request, "outerSysNo:外部系统编号", "taskId:任务ID");
		taskBiz.completeTask(request.getParameter("taskId"));
		return ResultUtil.createSucssAppResult("任务"+request.getParameter("taskId")+"执行成功");
	}
	
}
