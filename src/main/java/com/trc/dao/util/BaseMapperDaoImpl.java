package com.trc.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.trc.controller.ProcessController;
import com.trc.exception.DBException;
import com.trc.util.BeanToMapUtil;
import com.trc.util.CommonUtil;
import com.trc.util.JsonUtil;
import com.trc.util.Pagination;

@SuppressWarnings("hiding")
public class BaseMapperDaoImpl<T>  implements
		BaseMapperDao<T>, Serializable {
	
	private static final long serialVersionUID = 8401327704215118738L;

	private static Log log = LogFactory.getLog(ProcessController.class);
	
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate2;
	
	//public static final String POSTFIX_NAMESPACE = "trc.";
	
	public static final String POSTFIX_INSERT = ".insert";

	public static final String POSTFIX_UPDATE = ".update";

	public static final String POSTFIX_DELETE = ".delete";

	public static final String POSTFIX_DELETE_PRIAMARYKEY = ".deleteById";

	public static final String POSTFIX_SELECT = ".select";
	
	public static final String POSTFIX_SELECT_PRIAMARYKEY = ".selectByPrimaryKey";

	public static final String POSTFIX_SELECTMAP = ".selectByMap";

	public static final String POSTFIX_SELECTSQL = ".selectBySql";

	public static final String POSTFIX_COUNT = ".count";
	
	public static final String PAGE_TOTALCOUNT = ".totalCount";
	
	public static final String PAGE_PAGINATION = ".pagination";
	
	public static final String BATH_INSERT = ".batchInsert";
	
	
	/**
	 * 获取当前类的名称
	* @Title: getClassName 
	* @Description: TODO
	* @param @return    
	* @return String
	* @throws
	 */
	@SuppressWarnings("unchecked")
	Class<T> getClassType(){
		Class<T> entityClass = null;
        Type t = getClass().getGenericSuperclass();
        if(t instanceof ParameterizedType){
            Type[] p = ((ParameterizedType)t).getActualTypeArguments();
            entityClass = (Class<T>)p[0];
        }
        return entityClass;
	}
	
	/**
	 * 
	* @Title: getSqlId 
	* @Description: 获取数据库操作的sqlId
	* @param @param sqlId
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	protected String getSqlId(String sqlId){
		StringBuilder  builder = new StringBuilder();
		//builder.append(POSTFIX_NAMESPACE).append(getClassType().getName()).append(sqlId);
		builder.append(getClassType().getName()).append(sqlId);
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#get(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> T get(Object id)throws SQLException {
		T o = sqlSessionTemplate2.selectOne(getSqlId(POSTFIX_SELECT), id);
		/*if (o == null)
			throw new BaseException(BaseException.DATA_NOTFOUND, "未找到实体: " + id);*/
		return o;
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#getAll(java.lang.Class)
	 */
	@Override
	public <T> List<T> getAll() throws SQLException {
		return sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECT));
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#insert(java.lang.Object)
	 */
	@Override
	public int insertBean(Object o) throws SQLException {
		int count = sqlSessionTemplate2.insert(getSqlId(POSTFIX_INSERT), o);
		if(count < 1){
			throw new DBException(CommonUtil.joinStr("保存",getClassType().getName(),"对象",JsonUtil.parseToJson(o).toString(),"到数据库失败").toString());
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#update(java.lang.Object)
	 */
	@Override
	public int updateBean(Object o) throws SQLException { 
		return sqlSessionTemplate2.update(getSqlId(POSTFIX_UPDATE), o);
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#remove(java.lang.Object)
	 */
	@Override
	public int removeBean(Object o) throws SQLException {
		return sqlSessionTemplate2.delete(getSqlId(POSTFIX_DELETE), o);
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#removeById(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> int removeById(Object id)
			throws SQLException {
		return sqlSessionTemplate2.delete(getSqlId(POSTFIX_DELETE_PRIAMARYKEY), id);
	}
	
	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#find(java.lang.Class, java.util.Map)
	 */
	@Override
	public <T> List<T> find(Map<String, Object> map)
			throws SQLException {
		if (map == null || map.keySet().size() == 0)
			return sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECT));
		else {
			return sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECTMAP),map);
		}
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#find(java.lang.Class, java.lang.String)
	 */
	@Override
	public <T> List<T> findBySql(String sql)
			throws SQLException {
		if (StringUtils.isEmpty(sql))
			return sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECT));
		else
			return sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECTSQL),sql);
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#findBy(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> List<T> findBy(String name, Object value)
			throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		return find(map);
	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#findUniqueBy(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T findUniqueBy(String name, Object value) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PropertyUtils.getProperty(getClassType().newInstance(), name);
			map.put(name, value);
			map.put("findUniqueBy", "True");
			return (T) sqlSessionTemplate2.selectOne(getSqlId(POSTFIX_SELECTMAP), map);
		} catch (Exception e) {
			log.error("Error when propertie on entity," + e.getMessage(),
					e.getCause());
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see cn.resoft.dmps.service.IBatisGeneric#findByLike(java.lang.Class, java.lang.String, java.lang.String)
	 */
	@Override
	public <T> List<T> findByLike(String name, String value) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		map.put("findLikeBy", "True");
		return sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECTMAP),map);

	}

	/**
	 * 获取记录条数
	 */
	public Integer getCount(Map<String, Object> map) throws SQLException {
		return (Integer)sqlSessionTemplate2.selectOne(getSqlId(PAGE_TOTALCOUNT), map) ;
	}
	
	
	@Override
	public Pagination<T> pagination(Pagination<T> form) throws SQLException {
		Integer count = getCount(BeanToMapUtil.convertBeanToMap(form));
		List<T> datas = null;	
		if(count > 0){
			datas = sqlSessionTemplate2.selectList(getSqlId(PAGE_PAGINATION),BeanToMapUtil.convertBeanToMap(form));
		}
		form.setCount(count);
		if(CollectionUtils.isEmpty(datas)){
			datas = new ArrayList<T>();
		}
		form.setDatas(datas);
		return form;
	}

	@Override
	public T findById(String id) throws SQLException {
		List<T> list = sqlSessionTemplate2.selectList(getSqlId(POSTFIX_SELECT_PRIAMARYKEY),id);
		if(CollectionUtils.isEmpty(list))
			return null;
		return list.get(0);
	}

	@Override
	public int batchInsert(List<T> list) throws SQLException {
		return sqlSessionTemplate2.insert(getSqlId(BATH_INSERT), list);
	}

	@Override
	public int delete(Map<String, Object> param) throws SQLException {
		return sqlSessionTemplate2.delete(getSqlId(POSTFIX_DELETE), param);
	}
	
	
}
