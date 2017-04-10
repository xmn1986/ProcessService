package com.trc.dao;

import java.util.List;
import java.util.Map;

import com.trc.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record) throws Exception;

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    /**
     * 
    * @Title: select 
    * @Description: 查询用户
    * @param @param param Map类型参数
    * @param @return    设定文件 
    * @return List<UserInfo>    返回类型 
    * @throws
     */
    List<UserInfo> select(Map<String, Object> param) throws Exception;
    /**
     * 
    * @Title: selectMaxActivitiId 
    * @Description: 查询每个用户名对应的最后一个activiti用户
    * @param @param userName
    * @param @return
    * @param @throws Exception    设定文件 
    * @return String    返回类型 
    * @throws
     */
    Map<String,String> selectMaxActivitiId(String userName) throws Exception;
    
    /**
     * 
    * @Title: batchInsert 
    * @Description: 批量插入
    * @param @param userRoles
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int batchInsert(List<UserInfo> userInfos) throws Exception;
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
    
    /**
     * 
    * @Title: selectActivitiUserId 
    * @Description: 根据用户ID列表查询用户信息
    * @param @param userId
    * @param @return
    * @param @throws Exception    设定文件 
    * @return List<UserInfo>    返回类型 
    * @throws
     */
   List<UserInfo> selectActivitiUserId(List<String> userId)throws Exception;
   
   /**
    * 查询登录用户
    * @return
    * @throws Exception
    */
   UserInfo selectLoginUser(String username, String pwd)throws Exception;
    
}