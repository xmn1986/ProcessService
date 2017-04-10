package com.trc.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.trc.model.Dict;
import com.trc.model.OuterSystemConfig;
import com.trc.model.OuterSystemProcdef;
import com.trc.model.UserInfo;
import com.trc.util.Pagination;

public interface SystemBiz {
	
	/**
	 * 
	* @Title: login 
	* @Description: 登录 
	* @param @param username 用户名
	* @param @param pwd 密码
	* @param @return    设定文件 
	* @return ActIdUser    用户对象
	* @throws
	 */
	public UserInfo login(String username, String pwd) throws Exception;
	
	/**
	 * 查询外部系统配置分页
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public Pagination<OuterSystemConfig> outerSystemConfigPagination(Pagination<OuterSystemConfig> form) throws Exception;
	
	/**
	 * 
	* @Title: selectAllOuterSys 
	* @Description: 查询所有外部系统
	* @param @return    设定文件 
	* @return List<Map<String,String>>    返回类型 
	* @throws
	 */
	public List<Map<String, String>> selectAllOuterSys(); 
	/**
	 * 
	* @Title: outerSystemProcdefPagination 
	* @Description: 外部系统流程定义分页数据
	* @param @param form
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Pagination<OuterSystemProcdef>    返回类型 
	* @throws
	 */
	public Pagination<OuterSystemProcdef> outerSystemProcdefPagination(Pagination<OuterSystemProcdef> form) throws Exception; 
	
	/**
	 * 
	* @Title: selectAllProcDef 
	* @Description: 查询所有流程定义
	* @param @return
	* @param @throws SQLException    设定文件 
	* @return List<Map<String,String>>    返回类型 
	* @throws
	 */
	public List<Map<String, String>> selectAllProcDef() throws Exception;
	/**
	 * 
	* @Title: selectProcessType 
	* @Description: 查询流程类型
	* @param @param outerSysNo 外部系统编号
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<Dict>    返回类型 
	* @throws
	 */
	public List<Dict> selectProcessType(String outerSysNo) throws Exception;
	
	
}
