package com.trc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trc.biz.TaskBiz;
import com.trc.util.AppResult;
import com.trc.util.ResultUtil;
import com.trc.util.ValidateUtil;

@Controller
@RequestMapping("/taskListener")
public class TaskListenerController {

	@Autowired
	private TaskBiz taskBiz;
	
	/**
	 * 
	* @Title: saveEmployeeApplyTaskInfo 
	* @Description: 保存员工申请任务执行信息
	* @param @param request
	* @param @param modelMap
	* @param @return
	* @param @throws Exception    设定文件 
	* @return AppResult    返回类型 
	* @throws
	 */
	@RequestMapping("/saveEmployeeApplyTaskInfo")
	@ResponseBody
	public AppResult saveEmployeeApplyTaskInfo(HttpServletRequest request, ModelMap modelMap) throws Exception{
		ValidateUtil.paramNullCheck2(request, "outerSysNo:外部系统编号", "serviceType:服务类型","taskId","任务编号","parameter:回调参数");
		taskBiz.saveEmployeeApplyTaskInfo(request.getParameter("outerSysNo"), request.getParameter("taskId"), request.getParameter("serviceType"), request.getParameter("parameter"));
		return ResultUtil.createSucssAppResult("");
	}
	
}
