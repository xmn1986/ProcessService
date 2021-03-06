package com.trc.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
* @ClassName: ValidEnum 
* @Description: 是否有效枚举
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月6日 上午9:16:13 
*
 */
public enum ValidEnum {

	VALID("1","有效"),
	NOVALID("0","");
	
	private String code; 
	private String name; 
	
	ValidEnum(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 
	* @Title: getValidEnumByName 
	* @Description: 根据枚举名称获取枚举
	* @param @param name
	* @param @return    
	* @return ValidEnum
	* @throws
	 */
	public static ValidEnum getValidEnumByName(String name){
		for(ValidEnum validEnum : ValidEnum.values()){
			if(StringUtils.equals(name, validEnum.getName())){
				return validEnum;
			}
		}
		return null;
	}
	
	/**
	 * 
	* @Title: getValidEnumByCode 
	* @Description: 根据枚举编码获取枚举
	* @param @param name
	* @param @return    
	* @return ValidEnum
	* @throws
	 */
	public static ValidEnum getValidEnumByCode(String code){
		for(ValidEnum validEnum : ValidEnum.values()){
			if(StringUtils.equals(validEnum.getCode(), code)){
				return validEnum;
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
