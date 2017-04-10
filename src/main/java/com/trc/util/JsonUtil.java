/**   
* @Title: JsonUtil.java 
* @Package com.hoo.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 吴东雄
* @date 2015年11月18日 下午2:55:01 
* Copyright (c) 2015, 杭州海适云承科技有限公司 All Rights Reserved.
* @version V1.0   
*/
package com.trc.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;

import org.apache.commons.lang.StringUtils;

/** 
 * @ClassName: JsonUtil 
 * @Description: TODO
 * @author 吴东雄
 * @date 2015年11月18日 下午2:55:01 
 *  
 */
public class JsonUtil {
	
	/*
	 *包含一个空格的字符串
	 */
	public static final String QUOT = "&nbsp;";
	
	/**
	 * 对象转json对象
	 * @param object
	 * @return
	 */
	public static JSONObject parseToJson(Object object){
		if(object instanceof JSONObject)
			return (JSONObject)object;
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        return JSONObject.fromObject(object, jsonConfig);
	}
	
	/**
	 * 对象转json数组
	 * @param object
	 * @return
	 */
	public static JSONArray parseToJsonArray(Object object){
		if(object instanceof JSONArray)
			return (JSONArray)object;
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        return JSONArray.fromObject(object, jsonConfig);
	}
	
	public static Object getJsonVal(JSONObject jsonObject, String key){
		if(jsonObject.has(key)){
			if(null == jsonObject.get(key) || StringUtils.isEmpty(jsonObject.get(key).toString())){
				return "";
			}else{
				return jsonObject.get(key);
			}
		}else{
			return "";
		}
	}
	
	
	public static Map<String, String> converJsonToMap(String json){
		Map<String, String> map = new HashMap<String, String>();
		JSONObject jsonObject = JSONObject.fromObject(json);
		Iterator it = jsonObject.keys();  
		while(it.hasNext()){
			String key = String.valueOf(it.next());  
            String value = jsonObject.getString(key); 
			map.put(key, value);
		}
		return map;
	}
	
	public static Map<String, Object> converJsonToMap(JSONObject json){
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.fromObject(json);
		Iterator<?> it = jsonObject.keys();  
		while(it.hasNext()){
			String key = String.valueOf(it.next());  
			map.put(key, jsonObject.get(key));
		}
		return map;
	}
	
	
	public static List< Map<String, Object>> converJsonArrayToMapList(JSONArray array){
		List< Map<String, Object>> list = new ArrayList< Map<String, Object>>();
		for(Object obj : array){
			list.add(converJsonToMap((JSONObject)obj));
		}
		return list;
	}
	
	/**
	 * 
	* @Title: replaceNullValue 
	* @Description: 替换json中空值为指定的字符串
	* @param @param json
	* @param @param flag
	* @param @return    
	* @return JSONObject
	* @throws
	 */
	public static JSONObject replaceNullValue(JSONObject json, String flag){
		JSONObject result = new JSONObject();
		Iterator<?> it = json.keys();
		while(it.hasNext()){
			String key = it.next().toString();
			Object value = json.get(key);
			if(value instanceof JSONNull || StringUtils.isEmpty(String.valueOf(value)))
				result.put(key, flag);
			else
				result.put(key, json.get(key));
		}
		return result;
	}
	
    /**  
     * JSONObject排序  
     *   
     * @param obj  
     * @return  
     */  
    @SuppressWarnings("all")  
    public static JSONObject sortJsonObject(JSONObject obj) {  
        Map map = new TreeMap();  
        Iterator<String> it = obj.keys();  
        while (it.hasNext()) {  
            String key = it.next();  
            Object value = obj.get(key);  
            if (value instanceof JSONObject) {  
                // System.out.println(value + " is JSONObject");  
                map.put(key, sortJsonObject(JSONObject.fromObject(value)));  
            } else if (value instanceof JSONArray) {  
                // System.out.println(value + " is JSONArray");  
                //map.put(key, sortJsonArray(JSONArray.fromObject(value)));  
            } else {  
                map.put(key, value);  
            }  
        }  
        return JSONObject.fromObject(map);  
    }  
  
    
	public static void main(String[] args) {
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("AAAA", "aaaa");
    	jsonObject.put("CCCC", 223);
    	jsonObject.put("BBBB", "");
    	
    	
    	JSONObject map = JsonUtil.sortJsonObject(jsonObject);
    	
    	System.out.println("map="+map);
    }

}
