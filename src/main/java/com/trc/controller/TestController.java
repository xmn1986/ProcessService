package com.trc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trc.biz.LeaveBiz;
import com.trc.model.ActReProcdef;
import com.trc.util.Pagination;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private LeaveBiz leaveBiz;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		return "index";
	}
	
	@RequestMapping("/queryList")
	@ResponseBody
	public List<ActReProcdef> queryList(HttpServletRequest request, ModelMap modelMap){
		List<ActReProcdef> list = leaveBiz.queryList();
		return list;
	}
	
	  /*@RequestMapping({"/resultJson"})
	  public String getResultJson(TreateCustForm form, ModelMap modelMap)
	  {
	    Assert.notNull(form, "转诊信息分页查询参数为空");
	    Pagination pagination = null;
	    try {
	      pagination = this.treateManager.queryPagination(form);
	    } catch (Exception e) {
	      log.warn("分页查询异常", e);
	      pagination = new Pagination();
	    }
	    modelMap.put("results", Integer.valueOf(pagination.getCount()));
	    modelMap.put("currentCount", Integer.valueOf(pagination.getDatas().size()));
	    modelMap.put("rows", pagination.getDatas());
	    return "treate/treateListJson";
	  }*/
	
}
