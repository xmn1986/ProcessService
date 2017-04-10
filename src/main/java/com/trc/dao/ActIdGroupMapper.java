package com.trc.dao;

import java.sql.SQLException;
import java.util.List;

import com.trc.model.ActIdGroup;

public interface ActIdGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActIdGroup record);

    int insertSelective(ActIdGroup record);

    ActIdGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActIdGroup record);

    int updateByPrimaryKey(ActIdGroup record);
    
    /**
     * 
    * @Title: getAll 
    * @Description:  查询所有用户组
    * @param @return    设定文件 
    * @return List<ActIdGroup>    返回类型 
    * @throws
     */
    List<ActIdGroup> getAll()  throws SQLException;
    /**
     * 
    * @Title: batchInsert 
    * @Description: 批量添加
    * @param @param actIdGroups
    * @param @return
    * @param @throws Exception    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int batchInsert(List<ActIdGroup> actIdGroups) throws Exception;
    
}