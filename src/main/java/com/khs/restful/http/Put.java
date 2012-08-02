package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import com.khs.restful.system.RequestType;

public class Put extends BaseMethod {

	public Put() {
		super(RequestType.TEXT);
		setMethod(new HttpPut());
	}

	public Put(String uri, RequestType type) {
		super(type);
		setMethod(new HttpPut(uri));
	}

	public Put(URI uri, RequestType type) {
		super(type);
		setMethod(new HttpPut(uri));
	}

	@Override
	public void setURI(URI uri) {
		((HttpPut) getMethod()).setURI(uri);
	}
}
