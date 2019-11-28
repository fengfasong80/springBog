package com.fc.springmvc.utils;

import java.lang.reflect.Field;
import org.springframework.util.ReflectionUtils;


public class ReflectKit {
	
	/**
	 * 得到实体中某个属性的值
	 * @param entity
	 * @param fileName
	 * @return
	 */
	public static Object getFileValue(Object entity, String fileName) {
		Field findField = ReflectionUtils.findField(entity.getClass(), fileName);
		findField.setAccessible(true);
		return ReflectionUtils.getField(findField, entity);
	}
	
	/**
	 * 设置实体中某个属性的值 
	 * @param entity
	 * @param fileName
	 * @param value
	 */
	public static void setFileValue(Object entity, String fileName, Object value) {
		Field findField = ReflectionUtils.findField(entity.getClass(), fileName);
		findField.setAccessible(true);
		ReflectionUtils.setField(findField, entity, value);
	}

	/**
	 * 得到实体中某个属性的类型
	 * @param entity
	 * @param fileName
	 * @return
	 */
	public static Class<?> getFileType(Object entity, String fileName) {
		Field findField = ReflectionUtils.findField(entity.getClass(), fileName);
		return findField.getType();
	}
	
}
