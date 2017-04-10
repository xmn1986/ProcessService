package com.trc.acitiviti.event;

import java.io.Serializable;

import com.trc.util.CommonUtil;

public class TestExperis implements Serializable{

	private static final long serialVersionUID = -135297038868200712L;

	public void test(String arg0, String arg1){
		System.out.println(CommonUtil.joinStr(arg0).append("@@@@@@@@@@@@@").append(arg1));
	}
	
}
