package com.trc.biz;

public interface ExcuteBiz {
	
	public void excuteTask();
	
	/**
	 * 
	* @Title: employeApply 
	* @Description: 员工申请 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void employeApply();
	/**
	 * 
	* @Title: officerApproval 
	* @Description: 主管审批
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void officerApproval();
	/**
	 * 
	* @Title: managerApproval 
	* @Description: 经理审批
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void managerApproval();
	
	
}
