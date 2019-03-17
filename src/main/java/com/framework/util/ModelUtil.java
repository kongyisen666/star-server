package com.framework.util;

import java.lang.reflect.Field;
import java.util.Map;

import javax.persistence.Column;

public class ModelUtil {

	/**
	 * 单个对象转换
	 * 
	 * @param request
	 * @param _form
	 * @param field
	 * @param value
	 */
	public static void assignValue(Object _form, Field field,Map<String,Object> map) {
		String colName=field.getName();
		try {
			field.setAccessible(true);
			if(!map.containsKey(colName)) {
				return ;
			}
			Object object = map.get(colName);
			if(object==null){
				return ;
			}
			if (field.getType().getName().equals("java.lang.Long")) {
					field.set(_form,map.get(colName));
			} else if (field.getType().getName().equals("java.lang.Integer")) {
					field.set(_form, map.get(colName));
			} else if (field.getType().getName().equals("java.lang.Float")) {
					field.set(_form,map.get(colName));
			} else if (field.getType().getName().equals("java.lang.Double")) {
					field.set(_form, map.get(colName));
			} else if (field.getType().getName().equals("java.lang.Boolean")) {
				String val=(String) map.get(colName);
				if ("true".equals(val)||"1".equals(val)) {
					field.set(_form, true);
				} else {
					field.set(_form, false);
				}
			} else if (field.getType().getName().equals("java.util.Date")) {
				String val = map.get(colName).toString();
				field.set(_form, StringUtil.parseTimestamp(val));
			} else {
				String val = map.get(colName).toString();
					field.set(_form, val);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转换为实体类
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static Object toModel(Map<String,Object> map, Class clazz) {
		Object _form = null;
		try {
			_form = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return _form;
		}

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
				assignValue(_form, field, map);
		}

		return _form;
	}

}
