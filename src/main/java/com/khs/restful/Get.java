package com.khs.restful;

import java.net.URI;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.khs.restful.client.BaseMethod;
import com.khs.restful.system.RequestType;

public class Get extends BaseMethod {

	public Get() {
		super(RequestType.TEXT);
	}

	public Get(String name, String value) throws RestfulException {
		super(RequestType.TEXT);
		data(name, value);
	}

	public Get(Map<String, String> aMap) throws RestfulException {
		super(RequestType.TEXT);
		data(aMap);
	}
	
	@Override
	public void setURI(URI uri) throws RestfulException {
		URI aUri = initUri(uri);
		setMethod(new HttpGet(aUri));
	}
}
