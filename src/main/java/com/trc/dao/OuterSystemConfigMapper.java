package com.trc.dao;

import java.util.List;
import java.util.Map;

import com.trc.model.OuterSystemConfig;
import com.trc.util.Pagination;
public interface OuterSystemConfigMapper {

    int insert(OuterSystemConfig record);

    int insertSelective(OuterSystemConfig record);

    int updateByPrimaryKeySelective(OuterSystemConfig record);

    int updateByPrimaryKey(OuterSystemConfig record);
    
    /**
	 * 
	* @Title: pageQuery 
	* @Description: 分页查询
	* @param @param form
	* @param @return    设定文件 
	* @return List<ActReProcdef>    返回类型 
	* @throws
	 */
	public Pagination<OuterSystemConfig> pagination(Pagination<OuterSystemConfig> form) throws Exception;
	
	/**
	 * 
	* @Title: selectAllOuterSys 
	* @Description: 查询所有外部系统
	* @param @return    设定文件 
	* @return List<Map<String,String>>    返回类型 
	* @throws
	 */
	List<Map<String, String>> selectAllOuterSys(); 
    
}