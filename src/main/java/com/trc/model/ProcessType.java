package com.trc.model;

import java.util.Date;

public class ProcessType {
    private String id;

    private String processTypeName;

    private String outerSysNo;

    private String description;

    private String isValid;

    private String lastModifyOperator;

    private Date lastModifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProcessTypeName() {
        return processTypeName;
    }

    public void setProcessTypeName(String processTypeName) {
        this.processTypeName = processTypeName == null ? null : processTypeName.trim();
    }

    public String getOuterSysNo() {
        return outerSysNo;
    }

    public void setOuterSysNo(String outerSysNo) {
        this.outerSysNo = outerSysNo == null ? null : outerSysNo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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