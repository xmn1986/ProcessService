package com.trc.biz.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.trc.biz.Test2Biz;

@Service("test2Biz")
public class Test2BizImpl implements Test2Biz, Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5041365777871994106L;

	@Override
	public String test(String arg0, String arg1) {
		return arg0+"*************************"+arg1;
	}

}
