package com.khs.restful.client;

import com.khs.restful.system.Constants;

public abstract class Response implements IResponse {

	private String responseText;
	private boolean success = false;
	private int statusCode;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public int getStatusCode() {
		return statusCode;
	}

	@Override
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseText() {
		return responseText;
	}
	
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	
	public String getContenetType() {
		return Constants.TEXT_MIME;
	}	
	
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("isSuccess: ");
		buf.append(isSuccess());
		buf.append("\nResponse: ");
		buf.append(getResponseText());
		return buf.toString();
	}
}
