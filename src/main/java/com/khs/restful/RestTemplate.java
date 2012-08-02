package com.khs.restful;

import com.khs.restful.http.Get;
import com.khs.restful.http.IMethod;
import com.khs.restful.system.RequestType;

public class RestTemplate {

	public RestTemplate() {}
	
//	public RestTemplate(HttpConfig httpConfig) {}
	
	public JsonResponse json(String url) throws RestfulException {
		return execute(new Get(url, RequestType.JSON), JsonResponse.class);
	}
	
	public JsonResponse json(String url, IMethod method) throws RestfulException {
		method.setMethodValues(url, RequestType.JSON);
		return execute(method, JsonResponse.class);
	}

	public <T> T json(String url, Class<T> clazz) throws RestfulException {
		JsonResponse response = json(url);
		T anObject = response.serialize(clazz);
		return anObject;
	}
	
	public <T> T json(String url, IMethod method, Class<T> clazz) throws RestfulException {
		JsonResponse response = json(url, method);
		T anObject = response.serialize(clazz);
		return anObject;
	}

	private <T extends IResponse> T execute(IMethod method, Class<T> clazz) throws RestfulException {
		RestClient<T> client = new RestClient<T>(clazz);
		return client.execute(method);
	}
	
	
	public TextResponse text(String url) throws RestfulException {		
		return execute(new Get(url, RequestType.TEXT), TextResponse.class);
	} 

	public TextResponse text(String url, IMethod method) throws RestfulException {
		method.setMethodValues(url, RequestType.TEXT);
		return execute(method, TextResponse.class);
	}
}
