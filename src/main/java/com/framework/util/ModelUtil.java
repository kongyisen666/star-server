package com.framework.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ModelUtil {

	/**
	 * 通过内省复制一个新的类
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static <T> T copyModel(Object obj){
		T model = null;
		try {
			model = (T) obj.getClass().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return model;
		}
		try {
			PropertyDescriptor propertyDescriptor;
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field:fields) {
				propertyDescriptor = new PropertyDescriptor(field.getName(), obj.getClass());//创建一个属性描述器
				Object invoke = propertyDescriptor.getReadMethod().invoke(obj);
				if(null !=invoke){
					propertyDescriptor.getWriteMethod().invoke(model,invoke);
				}
			}
			return model;
		}catch (Exception e){
			return model;
		}
	}



	/**
	 * 单个对象转换
	 *
	 * @param _form
	 * @param field
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
				field.set(_form, Integer.parseInt(map.get(colName).toString()));
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

	/**
	 * 类转map
	 * @return Map<String,Object>
	 */
	public static Map<String,Object> toMap(Object obj) {
		Map<String,Object> map=new HashMap<String,Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				map.put(field.getName(), field.get(obj));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

}
