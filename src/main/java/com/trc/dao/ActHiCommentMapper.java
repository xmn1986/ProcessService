package com.trc.dao;

import com.trc.model.ActHiComment;

public interface ActHiCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiComment record);

    int insertSelective(ActHiComment record);

    ActHiComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActHiComment record);

    int updateByPrimaryKeyWithBLOBs(ActHiComment record);

    int updateByPrimaryKey(ActHiComment record);
}