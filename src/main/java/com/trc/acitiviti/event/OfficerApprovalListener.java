package com.trc.acitiviti.event;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import com.trc.util.AppResult;
import com.trc.util.HttpClientUtil;
import com.trc.util.PropertyResourceUtil;

public class OfficerApprovalListener implements TaskListener {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -173698548148052844L;

	@Override
	public void notify(DelegateTask arg0) {
		arg0.setVariable("officerFlag", false);//审批通过
		/*String url = PropertyResourceUtil.getPropertyVal("trcOA_url")+"leave/officerApproval.do";
		Map<String, String> param = new HashMap<String, String>();
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		AppResult result = httpClientUtil.getMethod(url, param);
		System.out.println("主管审批调用外部OA接口结果："+result.getResult());*/
	}

}
