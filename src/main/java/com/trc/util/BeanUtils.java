package com.trc.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.BeanMap;
import org.apache.log4j.Logger;

public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
	private static final Logger log = Logger.getLogger(BeanUtils.class);

	public static Object getPropertyAsObject(Object bean, String name) {
		Field[] fields = bean.getClass().getDeclaredFields();
		Field.setAccessible(fields, true);
		Object obj = null;
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if (!name.equals(field.getName()))
				continue;
			try {
				obj = field.get(bean);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage());
			} catch (IllegalAccessException e) {
				log.error(e.getMessage());
			}
		}

		return obj;
	}
	
	public static Object getFieldValue(Object entity,
			String fieldName) {
		return getPropertyAsObject(entity, fieldName);
	}
	
	
	public static Map<String,Object> getBeanMap(Object entity) {
		if(null==entity){
			return new HashMap<String, Object>();
		}
		return new BeanMap(entity);
	}
}
