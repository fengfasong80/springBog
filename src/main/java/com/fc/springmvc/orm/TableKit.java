package com.fc.springmvc.orm;

import com.jfinal.kit.StrKit;

public class TableKit {

	public static String getTableName(Object entity) {
		return StrKit.firstCharToLowerCase(entity.getClass().getSimpleName());
	}
	
	/**
	 * 得到实体表的主键
	 * @param entity
	 * @return
	 */
	public static String[] getPrimaryKey(Object entity) {
		String[] pks = {"id"};
		return pks;
	}
	
}
