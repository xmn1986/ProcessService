package com.trc.dao.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hsqldb.persist.LockFile.BaseException;

import com.trc.util.Pagination;

@SuppressWarnings("hiding")
public interface BaseMapperDao<T> {

	/**
	 * 根据ID获取对象
	 * 
	 * @throws BaseException
	 * @throws SQLException
	 */
	public abstract <T> T get(Object id)
			throws SQLException;

	/**
	 * 获取全部对象
	 * 
	 * @throws SQLException
	 */
	public abstract <T> List<T> getAll()
			throws SQLException;
	/**
	 * 获取记录条数
	 * 
	 * @throws SQLException
	 */
	public abstract Integer getCount(Map<String, Object> map)
			throws SQLException;
	/**
	 * 新增对象
	 * 
	 * @throws SQLException
	 */
	public abstract int insertBean(Object o) throws SQLException;

	/**
	 * 保存对象
	 * 
	 * @throws SQLException
	 */
	public abstract int updateBean(Object o) throws SQLException;

	/**
	 * 删除对象
	 * 
	 * @throws SQLException
	 */
	public abstract int removeBean(Object o) throws SQLException;
	
	/**
	 * 
	* @Title: delete 
	* @Description: 删除对象
	* @param @param param
	* @param @return
	* @param @throws SQLException    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	abstract int delete(Map<String, Object> param) throws SQLException;

	/**
	 * 根据ID删除对象
	 * 
	 * @throws SQLException
	 */
	public abstract <T> int removeById(Object id)
			throws SQLException;

	/**
	 * 
	* @Title: findById 
	* @Description: 根据ID查询对象
	* @param @param id
	* @param @return
	* @param @throws SQLException    设定文件 
	* @return T    返回类型 
	* @throws
	 */
	public abstract T findById(String id) throws SQLException;
	
	/**
	 * map查询.
	 * 
	 * @param map
	 *            包含各种属性的查询
	 * @throws SQLException
	 */
	public abstract <T> List<T> find(Map<String, Object> map) throws SQLException;

	/**
	 * sql 查询.
	 * 
	 * @param sql
	 *            直接sql的语句(需要防止注入式攻击)
	 * @throws SQLException
	 */
	public abstract <T> List<T> findBySql(String sql)
			throws SQLException;

	/**
	 * 根据属性名和属性值查询对象.
	 * 
	 * @return 符合条件的对象列表
	 * @throws SQLException
	 */
	public abstract <T> List<T> findBy(String name, Object value) throws SQLException;

	/**
	 * 根据属性名和属性值查询对象.
	 * 
	 * @return 符合条件的唯一对象
	 */
	public abstract <T> T findUniqueBy(String name, Object value) throws SQLException;

	/**
	 * 根据属性名和属性值以Like AnyWhere方式查询对象.
	 * 
	 * @throws SQLException
	 */
	public abstract <T> List<T> findByLike(String name, String value) throws SQLException;
	
	/**
	 * 
	* @Title: queryPagination 
	* @Description: 分页查询
	* @param @param form
	* @param @return    设定文件 
	* @return Pagination<T>    返回类型 
	* @throws
	 */
	public Pagination<T> pagination(Pagination<T> form) throws SQLException;
	
	/**
	 * 
	* @Title: batchInsert 
	* @Description: 批量插入
	* @param @param list
	* @param @return
	* @param @throws SQLException    设定文件 
	* @return long    返回类型 
	* @throws
	 */
	abstract int batchInsert(List<T> list) throws SQLException;

}
