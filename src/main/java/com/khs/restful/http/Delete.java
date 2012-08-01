package com.khs.restful.http;

import java.net.URI;

import org.apache.http.client.methods.HttpDelete;

import com.khs.restful.system.RequestType;

public class Delete extends BaseMethod {

	public Delete(String uri, RequestType type) {
		super(type);
		setMethod(new HttpDelete(uri));
	}
	
	public Delete(URI uri, RequestType type) {
		super(type);
		setMethod(new HttpDelete(uri));
	}
}