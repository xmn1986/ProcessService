package com.trc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.trc.model.ActReProcdef;
import com.trc.util.Pagination;

public interface ActReProcdefMapper {
	
	List<ActReProcdef> queryList();
	
    int deleteByPrimaryKey(String id);

    int insert(ActReProcdef record);

    int insertSelective(ActReProcdef record);

    ActReProcdef selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActReProcdef record);

    int updateByPrimaryKey(ActReProcdef record);
    
	/**
	 * 
	* @Title: pageQuery 
	* @Description: 分页查询
	* @param @param form
	* @param @return    设定文件 
	* @return List<ActReProcdef>    返回类型 
	* @throws
	 */
	public Pagination<ActReProcdef> pagination(Pagination<ActReProcdef> form) throws SQLException;
	
	/**
	 * 
	* @Title: selectAllProcDef 
	* @Description: 查询所有流程定义
	* @param @return
	* @param @throws SQLException    设定文件 
	* @return List<Map<String,String>>    返回类型 
	* @throws
	 */
	List<Map<String, String>> selectAllProcDef() throws SQLException;
	
}