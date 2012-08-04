package com.khs.restful.client;

import java.util.Map;

import com.khs.restful.Data;
import com.khs.restful.Header;
import com.khs.restful.RestfulException;
import com.khs.restful.system.RequestType;

public interface IMethod {

	IMethod data(String name, String value) throws RestfulException;
	
	IMethod data(Map<String, String> aMap) throws RestfulException;

	void setRequestType(RequestType type);

	String getUrl();
	
	void setMethodValues(String url, RequestType type, Header header, Data data) throws RestfulException;
}