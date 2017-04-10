package com.trc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trc.biz.SystemBiz;
import com.trc.enums.ResultEnum;
import com.trc.model.UserInfo;
import com.trc.util.AppResult;
import com.trc.util.ResultUtil;
import com.trc.util.ValidateUtil;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	private static Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private SystemBiz systemBiz;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index() {
		return "process/login";
	}
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		return "process/login";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public AppResult login(HttpServletRequest request,ModelMap modelMap,HttpSession session) throws Exception{
		ValidateUtil.paramNullCheck2(request, "account:登陆用户名","password:登陆密码");//参数是否存在校验
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		UserInfo user = systemBiz.login(account, password);
		AppResult appResult = ResultUtil.createSucssAppResult("登录成功");
		if(user != null){
			modelMap.addAttribute("user", user);
		}else{
			appResult.setAppcode(ResultEnum.FAILURE.getCode());
			appResult.setDatabuffer("登录失败");
		}
		return appResult;
	}
	
	@RequestMapping("/logout")  
	public String logout(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		model.remove("user");
		return "process/login";
	}
	
}
