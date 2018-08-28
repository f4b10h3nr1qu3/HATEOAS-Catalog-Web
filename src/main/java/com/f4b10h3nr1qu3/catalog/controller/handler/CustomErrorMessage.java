package com.f4b10h3nr1qu3.catalog.controller.handler;

import org.springframework.http.HttpStatus;

public class CustomErrorMessage {
	
	private HttpStatus status;
	private String reason;
	private String details;
	private Exception originalException;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Exception getOriginalException() {
		return originalException;
	}
	public void setOriginalException(Exception originalException) {
		this.originalException = originalException;
	}
	
}
