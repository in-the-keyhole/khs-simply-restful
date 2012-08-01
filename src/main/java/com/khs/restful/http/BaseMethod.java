package com.khs.restful.http;

import org.apache.http.client.methods.HttpUriRequest;

import com.khs.restful.IRequest;
import com.khs.restful.JsonRequest;
import com.khs.restful.system.RequestType;

public abstract class BaseMethod implements IMethod {

	private HttpUriRequest method;
	private IRequest request;
	
	public BaseMethod(RequestType type) {
		switch (type) {
			case JSON: request = new JsonRequest();
				break;
			default: request = new JsonRequest();
		}
	}
	
	@Override
	public HttpUriRequest getMethod() {
		return method;
	}
	
	protected void setMethod(HttpUriRequest method) {
		this.method = method;
	}
	
	protected void setContentType() {}
}
