package com.trc.dao;

import com.trc.model.ActHiAttachment;

public interface ActHiAttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActHiAttachment record);

    int insertSelective(ActHiAttachment record);

    ActHiAttachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActHiAttachment record);

    int updateByPrimaryKey(ActHiAttachment record);
}