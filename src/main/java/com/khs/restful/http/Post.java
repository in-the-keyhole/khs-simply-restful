package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.*;

import com.khs.restful.system.RequestType;

public class Post extends BaseMethod {
	
	public Post(String uri, RequestType type) {
		super(type);
		setMethod(new HttpPost(uri));
	}
	
	public Post(URI uri, RequestType type) {
		super(type);
		setMethod(new HttpPost(uri));
	}
		
}
