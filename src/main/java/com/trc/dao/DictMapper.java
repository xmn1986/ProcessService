package com.trc.dao;

import java.sql.SQLException;
import java.util.List;
import com.trc.model.Dict;

public interface DictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
    /**
     * 
    * @Title: selectOuterSysDict 
    * @Description: 根据字典类型查询外部系统字典 
    * @param @param outerSysNo
    * @param @param typeNo
    * @param @return
    * @param @throws SQLException    设定文件 
    * @return List<Dict>    返回类型 
    * @throws
     */
	List<Dict> selectOuterSysDict(String outerSysNo, String typeNo) throws SQLException;
    
}