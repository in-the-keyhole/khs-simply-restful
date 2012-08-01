package com.khs.restful;

import com.khs.restful.http.Get;
import com.khs.restful.http.IMethod;
import com.khs.restful.system.RequestType;

public class RestTemplate {

	//private IMethod method;
	
	public RestTemplate() {}
	
//	public RestTemplate(HttpConfig httpConfig) {}
	
	public JsonResponse json(String url) {
		return execute(new Get(url, RequestType.JSON), JsonResponse.class);
	}
	
	private <T> T json(String url, Class<T> clazz) {
		//return this.json(new Get(url, RequestType.JSON));
		return null;
	}
	
	private <T extends Response> T execute(IMethod method, Class<T> clazz) {
		RestClient client = new RestClient(clazz);
		return (T) client.execute(method);
	}
	
	
	
	public IResponse text(String url) {
		
		return null;
	}

	public IResponse text(String url, IMethod method) {
		return null;
	}
	
//	public IResponse json<IResponse>() {
//		return null;
//	}
}
