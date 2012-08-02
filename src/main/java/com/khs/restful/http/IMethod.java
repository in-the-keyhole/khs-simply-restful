package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.HttpUriRequest;

import com.khs.restful.RestfulException;
import com.khs.restful.system.RequestType;

public interface IMethod {

	public HttpUriRequest getMethod() throws RestfulException;

	public void setURI(String url) throws RestfulException;
	
	public void setURI(URI uri) throws RestfulException;
	
	public void setRequestType(RequestType type);
	
	public String getUrl();
	
	public void setMethodValues(String url, RequestType type) throws RestfulException;
}
