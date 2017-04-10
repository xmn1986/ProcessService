package com.trc.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
* @ClassName: ServiceTypeEnum 
* @Description: 服务类型枚举
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月1日 上午10:26:26 
*
 */
public enum ServiceTypeEnum {

	SUCCESS("0","HTTP"),
	FAILURE("1","WEBSERVICE");
	
	private String code; 
	private String name; 
	
	ServiceTypeEnum(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 
	* @Title: getServiceTypeEnumByName 
	* @Description: 根据枚举名称获取枚举
	* @param @param name
	* @param @return    
	* @return ServiceTypeEnum
	* @throws
	 */
	public static ServiceTypeEnum getServiceTypeEnumByName(String name){
		for(ServiceTypeEnum serviceTypeEnum : ServiceTypeEnum.values()){
			if(StringUtils.equals(name, serviceTypeEnum.getName())){
				return serviceTypeEnum;
			}
		}
		return null;
	}
	
	/**
	 * 
	* @Title: getServiceTypeEnumByCode 
	* @Description: 根据枚举编码获取枚举
	* @param @param name
	* @param @return    
	* @return ServiceTypeEnum
	* @throws
	 */
	public static ServiceTypeEnum getServiceTypeEnumByCode(String code){
		for(ServiceTypeEnum serviceTypeEnum : ServiceTypeEnum.values()){
			if(StringUtils.equals(serviceTypeEnum.getCode(), code)){
				return serviceTypeEnum;
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
