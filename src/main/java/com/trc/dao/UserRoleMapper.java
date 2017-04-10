package com.trc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.trc.model.UserInfo;
import com.trc.model.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record) throws SQLException;

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    /**
     * 
    * @Title: batchInsert 
    * @Description: 批量插入
    * @param @param userRoles
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int batchInsert(List<UserRole> userRoles) throws Exception;
    /**
     * 
    * @Title: select 
    * @Description: 查询用户角色
    * @param @param param
    * @param @return
    * @param @throws Exception    设定文件 
    * @return List<UserRole>    返回类型 
    * @throws
     */
    List<UserRole> select(Map<String, Object> param) throws Exception;
    /**
     * 
    * @Title: delete 
    * @Description: 根据条件删除
    * @param @param param
    * @param @return
    * @param @throws Exception    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int delete(Map<String, Object> param) throws Exception;
    
}