/**   
* @Title: JsonDateValueProcessor.java 
* @Package com.hoo.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 吴东雄
* @date 2015年11月18日 下午2:49:57 
* Copyright (c) 2015, 杭州海适云承科技有限公司 All Rights Reserved.
* @version V1.0   
*/
package com.trc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/** 
 * @ClassName: JsonDateValueProcessor 
 * @Description: TODO
 * @author 吴东雄
 * @date 2015年11月18日 下午2:49:57 
 *  
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

	private String format ="yyyy-MM-dd HH:mm:ss";   
    public Object processArrayValue(Object value, JsonConfig config) {   
        return process(value);   
    }   
  
    public Object processObjectValue(String key, Object value, JsonConfig config) {   
        return process(value);   
    }   
       
    private Object process(Object value){  
    	if(null == value)
    		return "";
    	else{
    		if(value instanceof Date){ 
                SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);   
                return sdf.format(value);   
            }  
    	}
        return value;
    }
    
	
}
