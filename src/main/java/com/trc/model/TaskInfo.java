package com.trc.model;

import java.util.Date;

public class TaskInfo {
    private Long id;

    private String outerSysNo;

    private String procInstId;

    private String procName;

    private String taskId;

    private String taskName;

    private String serviceType;

    private String parameter;

    private String status;

    private String errorMsg;

    private String returnParameter;

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

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName == null ? null : procName.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public String getReturnParameter() {
        return returnParameter;
    }

    public void setReturnParameter(String returnParameter) {
        this.returnParameter = returnParameter == null ? null : returnParameter.trim();
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