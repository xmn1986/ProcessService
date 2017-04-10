package com.trc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trc.biz.TaskBiz;
import com.trc.form.TaskFrom;
import com.trc.model.ProcessTask;
import com.trc.util.AppResult;
import com.trc.util.CommonUtil;
import com.trc.util.Pagination;
import com.trc.util.ResultUtil;
import com.trc.util.ValidateUtil;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	private static Log log = LogFactory.getLog(TaskController.class);

	@Autowired
	private TaskBiz taskBiz;

	@RequestMapping("/queryTask")
	@ResponseBody
	public AppResult queryTask(HttpServletRequest request, ModelMap modelMap){
		ValidateUtil.paramNullCheck2(request, "assingnee:委派人");
		Map<String, Object> params = CommonUtil.getRequestParam(request);
		List<ProcessTask> tasks = taskBiz.queryTask((String)params.get("assingnee"), params);
		/*JSONArray array = new JSONArray();
		for(Task t : tasks){
			JSONObject json = new JSONObject();
			json.put("id", t.getId());
			json.put("name", t.getName());
			array.add(json);
		}*/
		return ResultUtil.createSucssAppResult(tasks);
	}
	
	@RequestMapping("/queryCandidateGroupTask")
	@ResponseBody
	public AppResult queryCandidateGroupTask(HttpServletRequest request, ModelMap modelMap){
		ValidateUtil.paramNullCheck2(request, "candidateGroup:潜在委派组");
		List<ProcessTask> tasks = taskBiz.queryCandidateGroupTask(CommonUtil.getRequestParam(request));
		return ResultUtil.createSucssAppResult(tasks);
	}
	
	@RequestMapping("/taskList")
	public String taskList(HttpServletRequest request, ModelMap modelMap){
		return "process/taskList";
	}
	
	@RequestMapping("/taskListJson")
	public String taskListJson(TaskFrom form, ModelMap modelMap){
		ValidateUtil.paramNullCheck(form, "assingnee:委派人");
		Pagination<ProcessTask> pagination = null;
	    try {
	      pagination = taskBiz.taskPagination(form);
	    } catch (Exception e) {
	      log.warn("分页查询异常", e);
	      pagination = new Pagination<ProcessTask>();
	    }
	    modelMap.put("results", Integer.valueOf(pagination.getCount()));
	    modelMap.put("currentCount", Integer.valueOf(pagination.getDatas().size()));
	    modelMap.put("rows", pagination.getDatas());
	    return "data/taskListJson";
	}
	
	@RequestMapping("/completeTask")
	@ResponseBody
	public AppResult completeTask(HttpServletRequest request, ModelMap modelMap){
		ValidateUtil.paramNullCheck2(request, "taskId:任务ID");
		taskBiz.completeTask(request.getParameter("taskId"));
		return ResultUtil.createSucssAppResult("任务"+request.getParameter("taskId")+"执行成功");
	}
	
}
