package com.khs.restful;

import java.net.URI;
import java.util.Map;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;

import com.khs.restful.client.BaseMethod;
import com.khs.restful.system.RequestType;

public class Delete extends BaseMethod {

	public Delete() {
		super(RequestType.TEXT);
	}
	
	public Delete(String name, String value) throws RestfulException {
		super(RequestType.TEXT);
		data(name, value);
	}

	public Delete(Map<String, String> aMap) throws RestfulException {
		super(RequestType.TEXT);
		data(aMap);
	}

	@Override
	public void setURI(URI uri) throws RestfulException {
		URI aUri = initUri(uri);
		setMethod(new HttpDelete(aUri));
	}
}
