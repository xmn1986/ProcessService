package com.trc.biz.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trc.biz.Test2Biz;
import com.trc.biz.TestBiz;

@Service("testBiz")
public class TestBizImpl implements TestBiz , Serializable{

	private static final long serialVersionUID = -7230831021669023719L;

	@Autowired
	private Test2Biz test2Biz;
	
	@Override
	public String excute(String arg0, String arg1) {
		System.out.println(arg0+"$$$$$$$$$$$$$$$$"+arg1);
		System.out.println(test2Biz.test(arg0, arg1));
		return "123456";
	}

}
