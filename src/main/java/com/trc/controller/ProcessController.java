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

import com.trc.biz.ExcuteBiz;
import com.trc.biz.ProcessBiz;
import com.trc.form.ActReProcDefForm;
import com.trc.model.ActReProcdef;
import com.trc.util.AppResult;
import com.trc.util.CommonUtil;
import com.trc.util.Pagination;
import com.trc.util.ResultUtil;
import com.trc.util.ValidateUtil;

@Controller
@RequestMapping("/process")
public class ProcessController {

	private static Log log = LogFactory.getLog(ProcessController.class);
	
	@Autowired
	private ExcuteBiz excuteBiz;
	@Autowired
	private ProcessBiz processBiz;
	
	@RequestMapping("/excute")
	@ResponseBody
	public String excute(HttpServletRequest request, ModelMap modelMap){
		excuteBiz.excuteTask();
		return "执行成功";
	}
	
	@RequestMapping("/start")
	@ResponseBody
	public AppResult start(HttpServletRequest request, ModelMap modelMap) throws Exception{
		ValidateUtil.paramNullCheck2(request, "outerSysNo:外部系统编号", "processDefKey:流程定义KEY");
		Map<String, Object> params = CommonUtil.getRequestParam(request);
		JSONObject result = processBiz.updateAndStartProcess(request, params.get("processDefKey").toString(), params);
		return ResultUtil.createSucssAppResult(result);
	}
	
	/**
	 * 
	* @Title: processList 
	* @Description: 流程定义查询页面 
	* @param @param request
	* @param @param modelMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/processDefList")
	public String processList(HttpServletRequest request, ModelMap modelMap){
		return "process/processDefList";
	}
	
	  @RequestMapping({"/processDefListJson"})
	  public String processDefListJson(ActReProcDefForm form, ModelMap modelMap)
	  {
	    Pagination<ActReProcdef> pagination = null;
	    try {
	      pagination = processBiz.pagination(form);
	    } catch (Exception e) {
	      log.warn("分页查询异常", e);
	      pagination = new Pagination<ActReProcdef>();
	    }
	    modelMap.put("results", Integer.valueOf(pagination.getCount()));
	    modelMap.put("currentCount", Integer.valueOf(pagination.getDatas().size()));
	    modelMap.put("rows", pagination.getDatas());
	    return "data/processDefListJson";
	  }
	
	
	
	
	
}
