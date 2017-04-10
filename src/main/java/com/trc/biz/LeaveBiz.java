package com.trc.biz;

import java.util.List;

import com.trc.model.ActReProcdef;

public interface LeaveBiz {
	
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
	
	List<ActReProcdef> queryList();
	
}
