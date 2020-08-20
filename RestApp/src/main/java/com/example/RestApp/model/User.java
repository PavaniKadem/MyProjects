package com.example.RestApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class User {
	private Integer userId;
	private String userName;
	private String transcationID;
	/*
	 * private String serviceType;
	 */	private String failureMessage;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTranscationID() {
		return transcationID;
	}
	public void setTranscationID(String transcationID) {
		this.transcationID = transcationID;
	}
	
	/*
	 * public String getServiceType() { return serviceType; } public void
	 * setServiceType(String serviceType) { this.serviceType = serviceType; }
	 */
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	
	
}
