package com.khs.restful;

import com.khs.restful.system.Constants;

public abstract class Response implements IResponse {

	private String responseText;
	private boolean success = false;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
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
}
