package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.khs.restful.system.RequestType;

public class Get extends BaseMethod {

	public Get() {
		super(RequestType.TEXT);
		setMethod(new HttpGet());
	}

	public Get(String uri, RequestType type) {
		super(type);
		setMethod(new HttpGet(uri));
	}

	public Get(URI uri, RequestType type) {
		super(type);
		setMethod(new HttpGet(uri));
	}

	@Override
	public void setURI(URI uri) {
		((HttpGet) getMethod()).setURI(uri);
	}
}
