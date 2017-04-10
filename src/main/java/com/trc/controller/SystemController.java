package com.trc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trc.biz.SystemBiz;
import com.trc.form.OuterSystemConfigForm;
import com.trc.form.OuterSystemProcdefForm;
import com.trc.model.OuterSystemConfig;
import com.trc.model.OuterSystemProcdef;
import com.trc.util.AppResult;
import com.trc.util.CommonUtil;
import com.trc.util.Pagination;
import com.trc.util.ResultUtil;
import com.trc.util.ValidateUtil;

@Controller
@RequestMapping("/system")
public class SystemController {
	
	private static Log log = LogFactory.getLog(SystemController.class);
	
	@Autowired
	private SystemBiz systemBiz;

	@RequestMapping("/main")
	public String start(HttpServletRequest request, ModelMap modelMap){
		return "process/main";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		return "index";
	}
	
	/**
	 * 
	* @Title: outSysList 
	* @Description: 外部系统配置分页页面
	* @param @param request
	* @param @param modelMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/outSysList")
	public String outSysList(HttpServletRequest request, ModelMap modelMap){
		return "process/outSysList";
	}
	
	/**
	 * 
	* @Title: outSysListJson 
	* @Description: 外部系统配置分页查询数据
	* @param @param form
	* @param @param modelMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/outSysListJson")
	public String outSysListJson(OuterSystemConfigForm form, ModelMap modelMap){
		Pagination<OuterSystemConfig> pagination = null;
	    try {
	      pagination = systemBiz.outerSystemConfigPagination(form);
	    } catch (Exception e) {
	      log.warn("分页查询异常", e);
	      pagination = new Pagination<OuterSystemConfig>();
	    }
	    modelMap.put("results", Integer.valueOf(pagination.getCount()));
	    modelMap.put("currentCount", Integer.valueOf(pagination.getDatas().size()));
	    modelMap.put("rows", pagination.getDatas());
		return "data/outSysListJson";
	}
	
	/**
	 * 
	* @Title: outerSysProcessDefList 
	* @Description: 外部系统流程定义分页页面
	* @param @param request
	* @param @param modelMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/outerSysProcessDefList")
	public String outerSysProcessDefList(HttpServletRequest request, ModelMap modelMap){
		return "process/outerSysProcessDefList";
	}
	
	/**
	 * 
	* @Title: outerSysProcessDefListJson 
	* @Description: 外部系统流程定义分页数据
	* @param @param form
	* @param @param modelMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/outerSysProcessDefListJson")
	public String outerSysProcessDefListJson(OuterSystemProcdefForm form, ModelMap modelMap){
		Pagination<OuterSystemProcdef> pagination = null;
	    try {
	      pagination = systemBiz.outerSystemProcdefPagination(form);
	    } catch (Exception e) {
	      log.warn("分页查询异常", e);
	      pagination = new Pagination<OuterSystemProcdef>();
	    }
	    modelMap.put("results", Integer.valueOf(pagination.getCount()));
	    modelMap.put("currentCount", Integer.valueOf(pagination.getDatas().size()));
	    modelMap.put("rows", pagination.getDatas());
		return "data/outerSysProcessDefListJson";
	}
	
	/**
	 * @throws Exception 
	 * 
	* @Title: outerSysProcessDefList 
	* @Description: 外部系统流程定义分页页面
	* @param @param request
	* @param @param modelMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/outerSysProcessDefAdd")
	public String outerSysProcessDefAdd(HttpServletRequest request, ModelMap modelMap) throws Exception{
		modelMap.put("outerSystems", JSONArray.fromObject(systemBiz.selectAllOuterSys()));
		modelMap.put("procDefIds", JSONArray.fromObject(systemBiz.selectAllProcDef()));
		return "process/outerSysProcessDefAdd";
	}
	
	/**
	 * 
	* @Title: selectAllOuterSys 
	* @Description: 查询所有外部系统
	* @param @param request
	* @param @param modelMap
	* @param @return    设定文件 
	* @return AppResult    返回类型 
	* @throws
	 */
	@RequestMapping("/selectAllOuterSys")
	@ResponseBody
	public AppResult selectAllOuterSys(HttpServletRequest request, ModelMap modelMap){
		return ResultUtil.createSucssAppResult(systemBiz.selectAllOuterSys());
	}
	
	
	@RequestMapping("/selectProcessType")
	@ResponseBody
	public AppResult selectProcessType(HttpServletRequest request, ModelMap modelMap) throws Exception{
		ValidateUtil.paramNullCheck2(request, "outerSysNo:外部系统编号");
		return ResultUtil.createSucssAppResult(systemBiz.selectProcessType(request.getParameter("outerSysNo")));
	}
	
	
	
	
	
}
