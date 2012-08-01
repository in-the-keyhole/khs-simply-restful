package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;

import com.khs.restful.system.RequestType;

public class Get extends BaseMethod {

	public Get(String uri, RequestType type) {
		super(type);
		setMethod(new HttpGet(uri) );
	}
	
	public Get(URI uri, RequestType type) {
		super(type);
		setMethod(new HttpGet(uri));
	}	
}
