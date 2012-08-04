package com.khs.restful;

import java.net.URI;
import java.util.Map;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.khs.restful.client.BaseMethod;
import com.khs.restful.system.Constants;
import com.khs.restful.system.RequestType;

public class Put extends BaseMethod {

	public Put() {
		super(RequestType.TEXT);
	}

	public Put(String name, String value) throws RestfulException {
		super(RequestType.TEXT);
		data(name, value);
	}

	public Put(Map<String, String> aMap) throws RestfulException {
		super(RequestType.TEXT);
		data(aMap);
	}

	public HttpPut getHttpPut() {
		return (HttpPut) getMethod();
	}

	@Override
	protected void setEntity() {
		if ( getRequest().isFileContent() ) {
			
		} else {
			ContentType type = ContentType.create( getRequest().getContentType(), Constants.UTF8);
			StringEntity entity = new StringEntity(getData().toString(), type);
			getHttpPut().setEntity(entity);
		}
	}

	@Override
	public void setURI(URI uri) throws RestfulException {
		URI aUri = initUri(uri);
		setMethod(new HttpPut(aUri));
	}
}
