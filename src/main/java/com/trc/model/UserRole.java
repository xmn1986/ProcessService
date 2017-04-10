package com.trc.model;

import java.util.Date;

public class UserRole {
    private Long id;

    private String outerSysNo;

    private String roleId;

    private String roleName;

    private String userId;

    private String userName;

    private String activitiGroupId;

    private String activitiUserId;

    private String isValid;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getActivitiGroupId() {
        return activitiGroupId;
    }

    public void setActivitiGroupId(String activitiGroupId) {
        this.activitiGroupId = activitiGroupId == null ? null : activitiGroupId.trim();
    }

    public String getActivitiUserId() {
        return activitiUserId;
    }

    public void setActivitiUserId(String activitiUserId) {
        this.activitiUserId = activitiUserId == null ? null : activitiUserId.trim();
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