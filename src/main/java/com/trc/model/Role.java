package com.trc.model;

import java.util.Date;

public class Role {
    private String id;

    private String outerSysNo;

    private String name;

    private String description;

    private String activitiGroupId;

    private String isValid;

    private String lastModifyOperator;

    private Date lastModifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOuterSysNo() {
        return outerSysNo;
    }

    public void setOuterSysNo(String outerSysNo) {
        this.outerSysNo = outerSysNo == null ? null : outerSysNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getActivitiGroupId() {
        return activitiGroupId;
    }

    public void setActivitiGroupId(String activitiGroupId) {
        this.activitiGroupId = activitiGroupId == null ? null : activitiGroupId.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getLastModifyOperator() {
        return lastModifyOperator;
    }

    public void setLastModifyOperator(String lastModifyOperator) {
        this.lastModifyOperator = lastModifyOperator == null ? null : lastModifyOperator.trim();
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}