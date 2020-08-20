package com.example.RestClientSide.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class User {
	private Integer userId;
	private String userName;
	private Integer transcationID; 
	private String failureMessage;
	 
	 
	
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
	public Integer getTranscationID() { 
		return transcationID; } 
	public void setTranscationID(Integer i) { 
		this.transcationID = i;
	  } 
	public String getFailureMessage() { 
		return failureMessage; 
		} 
	public void setFailureMessage(String failureMessage) { 
		this.failureMessage = failureMessage; 
		}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", transcationID=" + transcationID
				+ ", failureMessage=" + failureMessage + "]";
	}
	
	/*
	 * @Override public String toString() { return "User [userId=" + userId +
	 * ", userName=" + userName + "]"; }
	 */
	
	  
	 
	
	
}
