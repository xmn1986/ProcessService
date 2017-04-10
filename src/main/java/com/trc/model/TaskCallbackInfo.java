package com.trc.model;

import java.util.Date;

public class TaskCallbackInfo {
    private Long id;

    private String taskId;

    private String serviceType;

    private String parameter;

    private String returnParameter;

    private String status;

    private String errorMsg;

    private String lastModifyOperator;

    private Date lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
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

    public String getReturnParameter() {
        return returnParameter;
    }

    public void setReturnParameter(String returnParameter) {
        this.returnParameter = returnParameter == null ? null : returnParameter.trim();
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