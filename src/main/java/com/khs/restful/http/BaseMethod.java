package com.khs.restful.http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpUriRequest;

import com.khs.restful.IRequest;
import com.khs.restful.JsonRequest;
import com.khs.restful.RestfulException;
import com.khs.restful.TextRequest;
import com.khs.restful.XmlRequest;
import com.khs.restful.system.RequestType;

public abstract class BaseMethod implements IMethod {

	private HttpUriRequest method;
	private IRequest request;

	public BaseMethod(RequestType type) {
		InitializeRequestType(type);
	}

	@Override
	public HttpUriRequest getMethod() {
		return method;
	}

	private void InitializeRequestType(RequestType type) {
		switch (type) {
		case JSON:
			request = new JsonRequest();
			break;
		case TEXT:
			request = new TextRequest();
			break;
		case XML:
			request = new XmlRequest();
			break;
		default:
			request = new TextRequest();
		}
	}

	protected void setMethod(HttpUriRequest method) {
		this.method = method;
	}

	@Override
	public void setRequestType(RequestType type) {
		InitializeRequestType(type);
	}

	@Override
	public void setURI(String url) throws RestfulException {
		try {
			setURI(new URI(url));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Invalid url", e);
		}
	}

	public String getUrl() {
		return method.getURI().toString();
	}
	
	public void setMethodValues(String url, RequestType type) throws RestfulException {
		setURI(url);
		setRequestType(type);	
	}
    protected void setContentType() {}
}
