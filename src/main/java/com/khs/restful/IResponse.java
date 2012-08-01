package com.khs.restful;

public interface IResponse {

	 public String getContenetType();
	 
	 public void setResponseText(String text);
	 
	 public String getResponseText();
	 
	 public boolean isSuccess();
	 
	 public void setSuccess(boolean success);
}
