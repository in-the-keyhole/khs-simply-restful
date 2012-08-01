package com.khs.restful;

import com.khs.restful.system.Constants;

public abstract class Response implements IResponse {

	private String responseText;
	private boolean success;
	
	@Override
	public boolean isSuccess() {
		return success;
	}
	
	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public String getResponseText() {
		return responseText;
	}
	
	@Override
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	
	@Override
	public String getContenetType() {
		return Constants.TEXT_MIME;
	}

//	public boolean isSuccess() {
//		if ( httpResponse != null && (httpResponse.getStatusLine().getStatusCode() == 200 ||
//				httpResponse.getStatusLine().getStatusCode() == 201)) {
//			return true;
//		}
//		return false;
//	}
	
}
