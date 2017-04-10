package com.trc.dao;

import java.sql.SQLException;
import java.util.List;

import com.trc.model.ActIdUser;
import com.trc.model.Role;

public interface ActIdUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActIdUser record);

    int insertSelective(ActIdUser record);

    ActIdUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActIdUser record);

    int updateByPrimaryKey(ActIdUser record);
    /**
     * 
    * @Title: selectLoginUser 
    * @Description: 查询登录用户
    * @param @param username 用户名
    * @param @param pwd 密码
    * @param @return    设定文件 
    * @return ActIdUser    返回类型 
    * @throws
     */
    ActIdUser selectLoginUser(String username, String pwd) throws SQLException;
    /**
     * 
    * @Title: batchInsert 
    * @Description: 批量插入
    * @param @param actIdUsers
    * @param @return
    * @param @throws Exception    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int batchInsert(List<ActIdUser> actIdUsers) throws Exception;
    
}