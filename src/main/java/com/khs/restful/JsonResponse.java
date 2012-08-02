package com.khs.restful;

import java.util.Set;

import com.khs.restful.json.GsonSerializer;
import com.khs.restful.json.IJsonSerializer;
import com.khs.restful.system.Constants;

public class JsonResponse extends Response implements IResponse {

	private IJsonSerializer<?> serializer; 
	
	@Override
	public String getContenetType() {
		return Constants.JSON_MIME;
	}
	
	public <T> T serialize(Class<T> clazz) {
		if ( serializer == null) {
			serializer = new GsonSerializer(clazz);
		}
		return (T) serializer.serializer(getResponseText());
	}
}
