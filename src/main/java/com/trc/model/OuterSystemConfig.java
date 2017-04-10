package com.trc.model;

import java.util.Date;

public class OuterSystemConfig {
	
	private Long id;

    private String outerSysNo;
	
    private String outerSysName;

    private String outerSysDescription;

    private String internalIp;

    private String netAreaIp;

    private String internetIp;

    private Long internetPort;

    private Long internalPort;

    private String networkType;

    private String email;

    private String phone;

    private String mobile;

    private String weixin;

    private String lastModifyOperator;

    private Date lastModifyTime;

    private String isValid;

    public String getOuterSysName() {
        return outerSysName;
    }

    public void setOuterSysName(String outerSysName) {
        this.outerSysName = outerSysName == null ? null : outerSysName.trim();
    }

    public String getOuterSysDescription() {
        return outerSysDescription;
    }

    public void setOuterSysDescription(String outerSysDescription) {
        this.outerSysDescription = outerSysDescription == null ? null : outerSysDescription.trim();
    }

    public String getInternalIp() {
        return internalIp;
    }

    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp == null ? null : internalIp.trim();
    }

    public String getNetAreaIp() {
        return netAreaIp;
    }

    public void setNetAreaIp(String netAreaIp) {
        this.netAreaIp = netAreaIp == null ? null : netAreaIp.trim();
    }

    public String getInternetIp() {
        return internetIp;
    }

    public void setInternetIp(String internetIp) {
        this.internetIp = internetIp == null ? null : internetIp.trim();
    }

    public Long getInternetPort() {
        return internetPort;
    }

    public void setInternetPort(Long internetPort) {
        this.internetPort = internetPort;
    }

    public Long getInternalPort() {
        return internalPort;
    }

    public void setInternalPort(Long internalPort) {
        this.internalPort = internalPort;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType == null ? null : networkType.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
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

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

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
		this.outerSysNo = outerSysNo;
	}
    
    
}