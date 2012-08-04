package com.khs.restful;

import java.util.Map;

import com.khs.restful.client.IMethod;
import com.khs.restful.client.IResponse;
import com.khs.restful.client.RestClient;
import com.khs.restful.system.RequestType;

public class RestTemplate {

	private Data data;
	private Header header;
	private IResponse response;
	
	public RestTemplate() {}
		
//	public RestTemplate(HttpConfig httpConfig) {}
	
	public IResponse getReponse() {
		return response;
	}
	
	public RestTemplate addData(String name, String value) throws RestfulException {
		if ( name == null) {
			throw new RestfulException("Name can not be null.");
		}
		if ( data == null) data = new Data();
		data.add(name, value);
		return this;
		
	}
	
	public RestTemplate setData(Map<String, String> aMap) throws RestfulException {
		data = new Data(aMap);
		return this;
		
	}

	public RestTemplate addHeader(String name, String value) throws RestfulException {
		if ( name == null) {
			throw new RestfulException("Name can not be null.");
		}
		if ( header == null) header = new Header();
		header.add(name, value);
		return this;
		
	}
	
	public RestTemplate setHeader(Map<String, String> aMap) throws RestfulException {
		header = new Header(aMap);
		return this;
		
	}

	public JsonResponse json(String url) throws RestfulException {
		return json(url, new Get());
	}
	
	public JsonResponse json(String url, IMethod method) throws RestfulException {
		return execute(url, method, RequestType.JSON, JsonResponse.class);
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

	private <T extends IResponse> T execute(String url, IMethod method, RequestType type,  Class<T> clazz) throws RestfulException {
		method.setMethodValues(url, type, header, data);
		RestClient<T> client = new RestClient<T>(clazz);
		response = client.execute(method);
		return (T) response;
	}
	
	
	public TextResponse text(String url) throws RestfulException {		
		return text(url, new Get());
	} 

	public TextResponse text(String url, IMethod method) throws RestfulException {
		return execute(url, method, RequestType.TEXT, TextResponse.class);
	}
}
