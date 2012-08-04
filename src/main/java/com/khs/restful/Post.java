package com.khs.restful;

import java.net.URI;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.khs.restful.client.BaseMethod;
import com.khs.restful.system.Constants;
import com.khs.restful.system.RequestType;

public class Post extends BaseMethod {

	public Post() {
		super(RequestType.TEXT);
	}
	
	public HttpPost getHttpPost() {
		return (HttpPost) getMethod();
	}

	public Post(String name, String value) throws RestfulException {
		super(RequestType.TEXT);
		data(name, value);
	}

	public Post(Map<String, String> aMap) throws RestfulException {
		super(RequestType.TEXT);
		data(aMap);
	}

	@Override
	protected void setEntity() {
		if ( getRequest().isFileContent() ) {
			
		} else {
			ContentType type = ContentType.create( getRequest().getContentType(), Constants.UTF8);
			StringEntity entity = new StringEntity(getData().toString(), type);
			getHttpPost().setEntity(entity);
		}
	}
	
	@Override
	public void setURI(URI uri) throws RestfulException {
//		URI aUri = initUri(uri);
		setMethod(new HttpPost(uri));
	}
}
