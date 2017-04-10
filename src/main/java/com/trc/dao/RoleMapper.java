package com.trc.dao;

import java.util.List;
import java.util.Map;

import com.trc.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record) throws Exception;

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 
    * @Title: select 
    * @Description: 查询角色
    * @param @param param Map类型参数
    * @param @return    设定文件 
    * @return List<UserInfo>    返回类型 
    * @throws
     */
    List<Role> select(Map<String, Object> param) throws Exception;
    /**
     * 
    * @Title: selectMaxActivitiGroupId 
    * @Description: 查询每个用户角色对应的最后一个activiti用户组
    * @param @param roleId 角色ID
    * @param @return
    * @param @throws Exception    设定文件 
    * @return String    返回类型 
    * @throws
     */
    Map<String,String> selectMaxActivitiGroupId(String roleId) throws Exception;
    /**
     * 
    * @Title: batchInsert 
    * @Description: 批量插入
    * @param @param roles
    * @param @return
    * @param @throws Exception    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int batchInsert(List<Role> roles) throws Exception;
    
    /**
     * 
    * @Title: selectActivitiGroupId 
    * @Description: 根据角色列表查询角色
    * @param @param roleIds
    * @param @return    设定文件 
    * @return List<Map<String,String>>    返回类型 
    * @throws
     */
    List<Role> selectActivitiGroupId(List<String> roleIds) throws Exception;
    
}