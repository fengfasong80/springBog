package com.fc.springmvc.orm;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fc.springmvc.utils.ReflectKit;



public class DbKit {

	
	
	private static String dirverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/tutorial?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private static String username = "root";
	private static String password = "root";
	
	
	
	/**
	 * 得到 jdbc connection对象
	 * @return
	 */
	private static Connection getConnection() {
		Connection conn = null;
        try {
        		Class.forName(dirverClass);
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conn;
	}
	
	/**
	 * 执行保存操作
	 * @param entity   需要保存的实体类
	 * @return
	 */
	public static Boolean save(Object entity) {
		StringBuilder sql = new StringBuilder();
		List<Object> paras = new ArrayList<Object>();
		String []pKeys = TableKit.getPrimaryKey(entity);
		SqlKit.forModelSave(entity, sql, paras);
		Connection connection = getConnection();
		PreparedStatement pst = null;
		Integer result = 0;
		try {
			pst = connection.prepareStatement(sql.toString(), 1);
			fillStatement(pst, paras);
			result = pst.executeUpdate();
			getModelGeneratedKey(entity, pst, pKeys);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, pst);
		}
		return result >= 1;
	}
	
	/**
	 * 执行更新操作
	 * @param entity 需要更新的实体
	 * @return
	 */
	public static Boolean update(Object entity) {
		String[] pKeys = TableKit.getPrimaryKey(entity);
		for (String pKey : pKeys){
			Object id = ReflectKit.getFileValue(entity, pKey);
			if (id == null)
				new RuntimeException("You can't update model without Primary Key, " + pKey + " can not be null.");
		}
		
		StringBuilder sql = new StringBuilder();
		List<Object> paras = new ArrayList<Object>();
		SqlKit.forModelUpdate(entity, sql, paras);
		if (paras.size() <= 1) {	// Needn't update
			return false;
		}
		
		Connection conn = null;
		PreparedStatement pst = null;
		int result = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql.toString());
			fillStatement(pst, paras);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			close(conn, pst);
		}
		return result >=1;
	}
	
	/**
	 * 删除
	 * @param table
	 * @return
	 */
	public static boolean delete(Object entity) {
		Connection conn = null;
		PreparedStatement pst = null;
		StringBuilder sql = new StringBuilder();
		List<Object> idValues = new ArrayList<Object>();
		SqlKit.forModelDeleteById(entity, sql, idValues);
		int result = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql.toString());
			fillStatement(pst, idValues);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pst);
		}
		return result >=1;
	}
	
	/**
	 * 查询
	 * @param clazz
	 * @param sql
	 * @param paras
	 * @return
	 */
	public static <T> List<T> find(Class<T> clazz, String sql, Object... paras){
		Connection conn = null;
		PreparedStatement pst = null;
		List<T> build = new ArrayList<>(); 
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			fillStatement(pst, Arrays.asList(paras));
			ResultSet rs = pst.executeQuery();
			build = build(rs, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pst);
		}
		return build;
	}
	
	/**
	 * 把ResultSet转换成相应实体的list对象
	 * @param rs
	 * @param modelClass
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> build(ResultSet rs, Class<?> modelClass) throws SQLException, ReflectiveOperationException {
		List<T> result = new ArrayList<T>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String[] labelNames = new String[columnCount + 1];
		int[] types = new int[columnCount + 1];
		buildLabelNamesAndTypes(rsmd, labelNames, types);
		while (rs.next()) {
			Object ob = modelClass.newInstance();
			for (int i=1; i<=columnCount; i++) {
				Object value;
				if (types[i] < Types.BLOB) {
					value = rs.getObject(i);
				} else {
					if (types[i] == Types.CLOB) {
						value = handleClob(rs.getClob(i));
					} else if (types[i] == Types.NCLOB) {
						value = handleClob(rs.getNClob(i));
					} else if (types[i] == Types.BLOB) {
						value = handleBlob(rs.getBlob(i));
					} else {
						value = rs.getObject(i);
					}
				}
				ReflectKit.setFileValue(ob, labelNames[i], value);
			}
			result.add((T)ob);
		}
		return result;
	}
	
	public static void buildLabelNamesAndTypes(ResultSetMetaData rsmd, String[] labelNames, int[] types) throws SQLException {
		for (int i=1; i<labelNames.length; i++) {
			labelNames[i] = rsmd.getColumnLabel(i);
			types[i] = rsmd.getColumnType(i);
		}
	}
	
	public static String handleClob(Clob clob) throws SQLException {
		if (clob == null)
			return null;
		
		Reader reader = null;
		try {
			reader = clob.getCharacterStream();
			if (reader == null)
				return null;
			char[] buffer = new char[(int)clob.length()];
			if (buffer.length == 0)
				return null;
			reader.read(buffer);
			return new String(buffer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (reader != null)
				try {reader.close();} catch (IOException e) {throw new RuntimeException(e);}
		}
	}
	
	public static byte[] handleBlob(Blob blob) throws SQLException {
		if (blob == null)
			return null;
		
		InputStream is = null;
		try {
			is = blob.getBinaryStream();
			if (is == null)
				return null;
			byte[] data = new byte[(int)blob.length()];		// byte[] data = new byte[is.available()];
			if (data.length == 0)
				return null;
			is.read(data);
			return data;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (is != null)
				try {is.close();} catch (IOException e) {throw new RuntimeException(e);}
		}
	}
	
	public static void close(Connection conn, PreparedStatement pst) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != pst) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 为Preparestatement占位符设置参数
	 * @param pst
	 * @param paras
	 * @throws SQLException
	 */
	private static void fillStatement(PreparedStatement pst, List<Object> paras) throws SQLException {
		// select * from user where username=? and password=?
		for (int i=0, size=paras.size(); i<size; i++) {
			pst.setObject(i + 1, paras.get(i));
		}
	}
	
	
	/**
	 * mysql 数据库的  bigint unsigned 对应的 java 类型为 BigInteger
	 * 但是 rs.getObject(1) 返回值为 Long 型，造成 model.save() 以后
	 * model.getId() 时的类型转换异常 
	 */
	private static void processGeneratedBigIntegerKey(Object model, String pKey, Object v) {
		if (v instanceof BigInteger) {
			ReflectKit.setFileValue(model, pKey, (BigInteger)v);
		} else if (v instanceof Number) {
			Number n = (Number)v;
			ReflectKit.setFileValue(model, pKey, BigInteger.valueOf(n.longValue()));
		} else {
			ReflectKit.setFileValue(model, pKey, v);
		}
	}

	/**
	 * 用于获取 Model.save() 以后自动生成的主键值，可通过覆盖此方法实现更精细的控制
	 * 目前只有 PostgreSqlDialect，覆盖过此方法
	 */
	public static void getModelGeneratedKey(Object model, PreparedStatement pst, String[] pKeys) throws SQLException {
		ResultSet rs = pst.getGeneratedKeys();
		for (String pKey : pKeys) {
			if (ReflectKit.getFileValue(model, pKey) == null) {
				if (rs.next()) {
					Class<?> colType = ReflectKit.getFileType(model, pKey);
					if (colType != null) {	// 支持没有主键的用法，有人将 model 改造成了支持无主键:济南-费小哥
						if (colType == Integer.class || colType == int.class) {
							ReflectKit.setFileValue(model, pKey, rs.getInt(1));
						} else if (colType == Long.class || colType == long.class) {
							ReflectKit.setFileValue(model, pKey, rs.getLong(1));
						} else if (colType == BigInteger.class) {
							processGeneratedBigIntegerKey(model, pKey, rs.getObject(1));
						} else {
							ReflectKit.setFileValue(model, pKey, rs.getObject(1));	// It returns Long for int colType for mysql
						}
					}
				}
			}
		}
		rs.close();
	}
	
}
