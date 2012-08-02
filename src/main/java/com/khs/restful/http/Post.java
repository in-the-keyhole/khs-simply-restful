package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.*;

import com.khs.restful.system.RequestType;

public class Post extends BaseMethod {

	public Post() {
		super(RequestType.TEXT);
		setMethod(new HttpPost());
	}

	public Post(String uri, RequestType type) {
		super(type);
		setMethod(new HttpPost(uri));
	}

	public Post(URI uri, RequestType type) {
		super(type);
		setMethod(new HttpPost(uri));
	}

	@Override
	public void setURI(URI uri) {
		((HttpPost) getMethod()).setURI(uri);
	}
}
