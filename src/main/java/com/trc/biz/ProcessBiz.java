package com.trc.biz;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.trc.model.ActReProcdef;
import com.trc.util.Pagination;

public interface ProcessBiz {

	/**
	 * 
	* @Title: startProcess 
	* @Description: 启动流程
	* @param @param processDefKey 流程定义key
	* @param @param params    流程启动参数
	* @return void    返回类型 
	* @throws
	 */
	public JSONObject  updateAndStartProcess(HttpServletRequest request, String processDefKey, Map<String, Object> params) throws Exception;
	
	/**
	 * 
	* @Title: pagination 
	* @Description: 流程定义分页查询
	* @param @param form
	* @param @return    设定文件 
	* @return List<ActReProcdef>    返回类型 
	* @throws
	 */
	public Pagination<ActReProcdef> pagination(Pagination<ActReProcdef> form) throws Exception;
	
	
	
}
