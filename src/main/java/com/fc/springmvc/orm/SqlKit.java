package com.fc.springmvc.orm;

import java.lang.reflect.Field;
import java.util.List;
import com.fc.springmvc.utils.ReflectKit;

public class SqlKit {

	/**
	 * 生成保存sql
	 * @param entity 实体类
	 * @param sql    
	 * @param paras
	 */
	public static void forModelSave(Object entity, StringBuilder sql, List<Object> paras) {
		sql.append("insert into `").append(TableKit.getTableName(entity)).append("`(");
		StringBuilder temp = new StringBuilder(") values(");

		for (Field field: entity.getClass().getDeclaredFields()) {
			String colName = field.getName();
			if (paras.size() > 0) {
				sql.append(", ");
				temp.append(", ");
			}
			sql.append('`').append(colName).append('`');
			temp.append('?');
			paras.add(ReflectKit.getFileValue(entity, field.getName()));
		}
		sql.append(temp.toString()).append(')');
	}
	
	
	/**
	 * 生成更新sql
	 * @param entity
	 * @param sql
	 * @param paras
	 */
	public static void forModelUpdate(Object entity, StringBuilder sql, List<Object> paras) {
		sql.append("update `").append(TableKit.getTableName(entity)).append("` set ");
		String[] pKeys = TableKit.getPrimaryKey(entity);
		for (Field field: entity.getClass().getDeclaredFields()) {
			String colName = field.getName();
			if (!isPrimaryKey(colName, pKeys)) {
				if (paras.size() > 0) {
					sql.append(", ");
				}
				sql.append('`').append(colName).append("` = ? ");
				paras.add(ReflectKit.getFileValue(entity, field.getName()));
			}
		}
		sql.append(" where ");
		for (int i=0; i<pKeys.length; i++) {
			if (i > 0) {
				sql.append(" and ");
			}
			sql.append('`').append(pKeys[i]).append("` = ?");
			paras.add(ReflectKit.getFileValue(entity, pKeys[i]));
		}
	}
	
	/**
	 * 生成删除sql
	 * @param entity  删除实体
	 * @param sql
	 * @param paras
	 * @return
	 */
	public static String forModelDeleteById(Object entity, StringBuilder sql, List<Object> paras) {
		String[] pKeys = TableKit.getPrimaryKey(entity);
		sql.append("delete from `");
		sql.append(entity.getClass().getSimpleName());
		sql.append("` where ");
		for (int i=0; i<pKeys.length; i++) {
			if (i > 0) {
				sql.append(" and ");
			}
			sql.append('`').append(pKeys[i]).append("` = ?");
			paras.add(ReflectKit.getFileValue(entity, pKeys[i]));
		}
		return sql.toString();
	}
	
	private static boolean isPrimaryKey(String colName, String[] pKeys) {
		for (String pKey : pKeys) {
			if (colName.equalsIgnoreCase(pKey)) {
				return true;
			}
		}
		return false;
	}
	
}
