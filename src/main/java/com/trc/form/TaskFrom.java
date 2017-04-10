package com.trc.form;

import com.trc.model.ProcessTask;
import com.trc.util.Pagination;

public class TaskFrom extends Pagination<ProcessTask>{

	/**
	 * 委派人
	 */
	private String assignee; 
	/**
	 * 候选委派人
	 */
	private String candidateUser;
	/**
	 * 候选委派组,多个组用","号分割
	 */
	private String candidateGroup;
	
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getCandidateUser() {
		return candidateUser;
	}
	public void setCandidateUser(String candidateUser) {
		this.candidateUser = candidateUser;
	}
	public String getCandidateGroup() {
		return candidateGroup;
	}
	public void setCandidateGroup(String candidateGroup) {
		this.candidateGroup = candidateGroup;
	}
	
	
	
}
