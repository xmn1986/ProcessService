package com.trc.model;

import java.util.Date;

public class OuterSystemProcdef {
    private Long id;

    private String outerSysNo;

    private String outerSysName;

    private String processTypeId;

    private String procDefId;

    private String procName;

    private String groupId;

    private String lastModifyOperator;

    private Date lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOuterSysNo() {
        return outerSysNo;
    }

    public void setOuterSysNo(String outerSysNo) {
        this.outerSysNo = outerSysNo == null ? null : outerSysNo.trim();
    }

    public String getOuterSysName() {
        return outerSysName;
    }

    public void setOuterSysName(String outerSysName) {
        this.outerSysName = outerSysName == null ? null : outerSysName.trim();
    }

    public String getProcessTypeId() {
        return processTypeId;
    }

    public void setProcessTypeId(String processTypeId) {
        this.processTypeId = processTypeId == null ? null : processTypeId.trim();
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId == null ? null : procDefId.trim();
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName == null ? null : procName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
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