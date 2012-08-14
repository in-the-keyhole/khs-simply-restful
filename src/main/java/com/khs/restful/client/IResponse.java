package com.khs.restful.client;

public interface IResponse {

	 public String getContenetType();
	 
	 public String getResponseText();
	 
	 public boolean isSuccess();
	 
	 public void setResponseText(String text);
	 
	 public void setSuccess(boolean success);
	 
	 public void setStatusCode(int code);
	 
	 public int getStatusCode();
}
