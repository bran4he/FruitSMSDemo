package com.fruit.sales.dao.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fruit.sales.common.StringTools;

/**
 * 实体类名和数据库表名去除（_）后一致，大小写无区别
 */
public class BaseDaoImpl<T> implements BaseDao<T> ,Serializable{

	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = -4404021901527702693L;
	/**
	 * 设置一些操作的常量
	 */
	public static final String SQL_INSERT = "insert";
	public static final String SQL_UPDATE = "update";
	public static final String SQL_DELETE = "delete";

	/**
	 * 泛型
	 */
	private Class<T> entityClass;
	private String simpleName;
	
	/**
	 * 简化数据操作
	 */
//	@Resource(name = "jdbcTemplate")
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];
		simpleName = StringTools.getTableName(entityClass.getSimpleName());
		System.out.println("Dao实现类是：" + entityClass.getName());
	}

	@Override
	public Integer getMaxId() {
		StringBuilder sql = new StringBuilder("SELECT max(id) from ");
		sql.append(simpleName).append(" ");
		Integer maxId = jdbcTemplate.queryForObject(sql.toString(),Integer.class);
		return maxId;
	}

	@Override
	public String getNextId() {
		return String.valueOf(getMaxId() + 1);
	}
	
	@Override
	public void save(T entity) {
		String sql = this.makeSql(SQL_INSERT);
		Object[] args = this.setArgs(entity, SQL_INSERT);
		int[] argTypes = this.setArgTypes(entity, SQL_INSERT);
		jdbcTemplate.update(sql.toString(), args, argTypes);
	}

	@Override
	public void update(T entity) {
		String sql = this.makeSql(SQL_UPDATE);
		Object[] args = this.setArgs(entity, SQL_UPDATE);
		int[] argTypes = this.setArgTypes(entity, SQL_UPDATE);
		jdbcTemplate.update(sql, args, argTypes);
	}

	@Override
	public void delete(T entity) {
		String sql = this.makeSql(SQL_DELETE);
		Object[] args = this.setArgs(entity, SQL_DELETE);
		int[] argTypes = this.setArgTypes(entity, SQL_DELETE);
		jdbcTemplate.update(sql, args, argTypes);
	}

	@Override
	public void delete(Serializable id) {
		String sql = " DELETE FROM " + simpleName
				+ " WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void deleteAll() {
		String sql = " TRUNCATE TABLE " + simpleName;
		jdbcTemplate.execute(sql);
	}


	@Override
	public T findById(Serializable id) {
		String sql = "SELECT * FROM " + simpleName
				+ " WHERE id=?";
		RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
		return jdbcTemplate.query(sql, rowMapper, id).get(0);
	}

    @Override  
    public List<T> findAll() {  
        String sql = "SELECT * FROM " + simpleName;  
        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);  
        return jdbcTemplate.query(sql, rowMapper);  
    }  
  
    @Override  
    public QueryResult<T> findByPageList(int pageNo, int pageSize) {  
        List<T> list = this.find(pageNo, pageSize, null, null);  
        int totalRow = this.count(null);  
        return new QueryResult<T>(list, totalRow);  
    }  
  
    @Override  
    public QueryResult<T> findByPageList(int pageNo, int pageSize, Map<String, String> where) {  
        List<T> list = this.find(pageNo, pageSize, where, null);  
        int totalRow = this.count(where);  
        return new QueryResult<T>(list, totalRow);  
    }  
  
    @Override  
    public QueryResult<T> findByPageList(int pageNo, int pageSize, LinkedHashMap<String, String> orderby) {  
        List<T> list = this.find(pageNo, pageSize, null, orderby);  
        int totalRow = this.count(null);  
        return new QueryResult<T>(list, totalRow);  
    }  
  
    @Override  
    public QueryResult<T> findByPageList(int pageNo, int pageSize, Map<String, String> where, LinkedHashMap<String, String> orderby) {  
        List<T> list = this.find(pageNo, pageSize, where, orderby);  
        int totalRow = this.count(where);  
        return new QueryResult<T>(list, totalRow);  
    } 

	/**
	 *  组装SQL
	 */
	private String makeSql(String sqlFlag) {
		StringBuffer sql = new StringBuffer();
		Field[] fields = entityClass.getDeclaredFields();
		if (sqlFlag.equals(SQL_INSERT)) {
			sql.append(" INSERT INTO " + simpleName);
			sql.append("(");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true); // 暴力反射
				String column = fields[i].getName();
				sql.append(column).append(",");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(") VALUES (");
			for (int i = 0; fields != null && i < fields.length; i++) {
				sql.append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(")");
		} else if (sqlFlag.equals(SQL_UPDATE)) {
			sql.append(" UPDATE " + simpleName + " SET ");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true); // 暴力反射
				String column = fields[i].getName();
				if (column.equals("id")) { // id 代表主键
					continue;
				}
				sql.append(column).append("=").append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE id=?");
		} else if (sqlFlag.equals(SQL_DELETE)) {
			sql.append(" DELETE FROM " + simpleName
					+ " WHERE id=?");
		}
		System.out.println("SQL=" + sql);
		return sql.toString();

	}

	/**
	 *  设置参数
	 */
	private Object[] setArgs(T entity, String sqlFlag) {
		Field[] fields = entityClass.getDeclaredFields();
		if (sqlFlag.equals(SQL_INSERT)) {
			Object[] args = new Object[fields.length];
			for (int i = 0; args != null && i < args.length; i++) {
				try {
					fields[i].setAccessible(true); // 暴力反射
					args[i] = fields[i].get(entity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return args;
		} else if (sqlFlag.equals(SQL_UPDATE)) {
			Object[] tempArr = new Object[fields.length];
			for (int i = 0; tempArr != null && i < tempArr.length; i++) {
				try {
					fields[i].setAccessible(true); // 暴力反射
					tempArr[i] = fields[i].get(entity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Object[] args = new Object[fields.length];
			System.arraycopy(tempArr, 1, args, 0, tempArr.length - 1); // 数组拷贝
			args[args.length - 1] = tempArr[0];
			return args;
		} else if (sqlFlag.equals(SQL_DELETE)) {
			Object[] args = new Object[1]; // 长度是1
			fields[0].setAccessible(true); // 暴力反射
			try {
				args[0] = fields[0].get(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return args;
		}
		return null;

	}

	/**
	 *  设置参数类型(缺少的用到了再添加)
	 */
	private int[] setArgTypes(T entity, String sqlFlag) {
		Field[] fields = entityClass.getDeclaredFields();
		if (sqlFlag.equals(SQL_INSERT)) {
			int[] argTypes = new int[fields.length];
			try {
				for (int i = 0; argTypes != null && i < argTypes.length; i++) {
					fields[i].setAccessible(true); // 暴力反射
//					System.out.println("=========fields[i].get(entity):" + fields[i].get(entity));
					if (fields[i].get(entity).getClass().getName()
							.equals("java.lang.String")) {
						argTypes[i] = Types.VARCHAR;
					} else if (fields[i].get(entity).getClass().getName()
							.equals("java.lang.Double")) {
						argTypes[i] = Types.DECIMAL;
					} else if (fields[i].get(entity).getClass().getName()
							.equals("java.lang.Integer")) {
						argTypes[i] = Types.INTEGER;
					} else if (fields[i].get(entity).getClass().getName()
							.equals("java.util.Date")) {
						argTypes[i] = Types.DATE;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return argTypes;
		} else if (sqlFlag.equals(SQL_UPDATE)) {
			int[] tempArgTypes = new int[fields.length];
			int[] argTypes = new int[fields.length];
			try {
				for (int i = 0; tempArgTypes != null && i < tempArgTypes.length; i++) {
					fields[i].setAccessible(true); // 暴力反射
					if (fields[i].get(entity).getClass().getName()
							.equals("java.lang.String")) {
						tempArgTypes[i] = Types.VARCHAR;
					} else if (fields[i].get(entity).getClass().getName()
							.equals("java.lang.Double")) {
						tempArgTypes[i] = Types.DECIMAL;
					} else if (fields[i].get(entity).getClass().getName()
							.equals("java.lang.Integer")) {
						tempArgTypes[i] = Types.INTEGER;
					} else if (fields[i].get(entity).getClass().getName()
							.equals("java.util.Date")) {
						tempArgTypes[i] = Types.DATE;
					}
				}
				System.arraycopy(tempArgTypes, 1, argTypes, 0,
						tempArgTypes.length - 1); // 数组拷贝
				argTypes[argTypes.length - 1] = tempArgTypes[0];

			} catch (Exception e) {
				e.printStackTrace();
			}
			return argTypes;

		} else if (sqlFlag.equals(SQL_DELETE)) {
			int[] argTypes = new int[1]; // 长度是1
			try {
				fields[0].setAccessible(true); // 暴力反射
				if (fields[0].get(entity).getClass().getName()
						.equals("java.lang.String")) {
					argTypes[0] = Types.VARCHAR;
				} else if (fields[0].get(entity).getClass().getName()
						.equals("java.lang.Integer")) {
					argTypes[0] = Types.INTEGER;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return argTypes;
		}
		return null;
	}

	/**
	 * default mysql db
	 * select * from table limit (start-1)*limit,limit; 其中start是页码，limit是每页显示的条数。
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param where
	 * @param orderby
	 * @return
	 */
	private List<T> find(int pageNo, int pageSize, Map<String, String> where, LinkedHashMap<String, String> orderby) {
		
		StringBuffer sql = new StringBuffer(" SELECT * FROM "+ simpleName);
		if (where != null && where.size() > 0) {
			sql.append(" WHERE "); // 注意不是where
			for (Map.Entry<String, String> me : where.entrySet()) {
				String columnName = me.getKey();
				String columnValue = me.getValue();
				sql.append(columnName).append(" ").append(columnValue)
						.append(" AND "); // 没有考虑or的情况
			}
			int endIndex = sql.lastIndexOf("AND");
			if (endIndex > 0) {
				sql = new StringBuffer(sql.substring(0, endIndex));
			}
		}
		if (orderby != null && orderby.size() > 0) {
			sql.append(" ORDER BY ");
			for (Map.Entry<String, String> me : orderby.entrySet()) {
				String columnName = me.getKey();
				String columnValue = me.getValue();
				sql.append(columnName).append(" ").append(columnValue)
						.append(",");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
		}
		int indexFirst = (pageNo - 1) * pageSize;
		int indexLast = pageSize;
		sql.append(" limit ?,? ");
		System.out.println("SQL=" + sql);
		Object[] args = { indexFirst, indexLast };
		RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
		return jdbcTemplate.query(sql.toString(), args, rowMapper);
	}
	
	/**
	 * oracle db
	 * @param pageNo
	 * @param pageSize
	 * @param where
	 * @param orderby
	 * @return
	 */
	private List<T> findOracle(int pageNo, int pageSize, Map<String, String> where, LinkedHashMap<String, String> orderby) {
		
		StringBuffer sql = new StringBuffer(
				" SELECT * FROM (SELECT t.*,ROWNUM rn FROM (SELECT * FROM "
						+ simpleName);
		if (where != null && where.size() > 0) {
			sql.append(" WHERE "); // 注意不是where
			for (Map.Entry<String, String> me : where.entrySet()) {
				String columnName = me.getKey();
				String columnValue = me.getValue();
				sql.append(columnName).append(" ").append(columnValue)
				.append(" AND "); // 没有考虑or的情况
			}
			int endIndex = sql.lastIndexOf("AND");
			if (endIndex > 0) {
				sql = new StringBuffer(sql.substring(0, endIndex));
			}
		}
		if (orderby != null && orderby.size() > 0) {
			sql.append(" ORDER BY ");
			for (Map.Entry<String, String> me : orderby.entrySet()) {
				String columnName = me.getKey();
				String columnValue = me.getValue();
				sql.append(columnName).append(" ").append(columnValue)
				.append(",");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
		}
		sql.append(" ) t WHERE ROWNUM<=? ) WHERE rn>=? ");
		System.out.println("SQL=" + sql);
		Object[] args = { pageNo * pageSize, (pageNo - 1) * pageSize + 1 };
		RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
		return jdbcTemplate.query(sql.toString(), args, rowMapper);
	}

	private int count(Map<String, String> where) {
		StringBuffer sql = new StringBuffer(" SELECT COUNT(*) FROM "
				+ simpleName);
		if (where != null && where.size() > 0) {
			sql.append(" WHERE ");
			for (Map.Entry<String, String> me : where.entrySet()) {
				String columnName = me.getKey();
				String columnValue = me.getValue();
				sql.append(columnName).append(" ").append(columnValue)
						.append(" AND "); // 没有考虑or的情况
			}
			int endIndex = sql.lastIndexOf("AND");
			if (endIndex > 0) {
				sql = new StringBuffer(sql.substring(0, endIndex));
			}
		}
		System.out.println("SQL=" + sql);
		return jdbcTemplate.queryForObject(sql.toString(),Integer.class);
	}



}
