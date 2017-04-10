package com.trc.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
* @ClassName: TaskStatusEnum 
* @Description: 任务状态枚举
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月1日 上午11:47:53 
*
 */
public enum TaskStatusEnum {

	WAITING("0","等待执行"),
	SUCCESS("1","执行成功"),
	FAILURE("2","执行失败"),
	RETRY("3","重试执行");
	
	private String code; 
	private String name; 
	
	TaskStatusEnum(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 
	* @Title: getTaskStatusEnumByName 
	* @Description: 根据枚举名称获取枚举
	* @param @param name
	* @param @return    
	* @return TaskStatusEnum
	* @throws
	 */
	public static TaskStatusEnum getTaskStatusEnumByName(String name){
		for(TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()){
			if(StringUtils.equals(name, taskStatusEnum.getName())){
				return taskStatusEnum;
			}
		}
		return null;
	}
	
	/**
	 * 
	* @Title: getTaskStatusEnumByCode 
	* @Description: 根据枚举编码获取枚举
	* @param @param name
	* @param @return    
	* @return TaskStatusEnum
	* @throws
	 */
	public static TaskStatusEnum getTaskStatusEnumByCode(String code){
		for(TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()){
			if(StringUtils.equals(taskStatusEnum.getCode(), code)){
				return taskStatusEnum;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
