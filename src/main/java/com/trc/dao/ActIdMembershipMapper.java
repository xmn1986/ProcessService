package com.trc.dao;

import java.util.List;
import java.util.Map;

import com.trc.model.ActIdMembership;

public interface ActIdMembershipMapper {
    int deleteByPrimaryKey(ActIdMembership key);

    int insert(ActIdMembership record);

    int insertSelective(ActIdMembership record);
    
    /**
     * 
    * @Title: batchInsert 
    * @Description: 批量插入
    * @param @param userRoles
    * @param @return
    * @param @throws Exception    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int batchInsert(List<ActIdMembership> actIdMemberships) throws Exception;
    
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