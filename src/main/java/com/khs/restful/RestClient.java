package com.khs.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;

import com.khs.restful.http.IMethod;

public class RestClient  {

	private DefaultHttpClient client;
	private IResponse response = null;
	private Class<? extends Response> responseClass;
	
	public <T extends Response> RestClient(Class<T> clazz) {
		client = new DefaultHttpClient();
		responseClass = clazz;
	}

	private void InitalizeResponse() {
//		responseClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			response = responseClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void retrieveResponse(HttpResponse httpResponse) throws IllegalStateException, IOException {
		InitalizeResponse();
		BufferedReader br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));

		StringBuffer output = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			output.append(line);
		}
		response.setResponseText(output.toString());
	}

	public IResponse execute(IMethod method) {
		try {						
			HttpResponse httpResponse = client.execute(method.getMethod());
			retrieveResponse(httpResponse);			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( client != null ) {
				client.getConnectionManager().shutdown();
			}
		}
		return response;
	}
	
//	public Class<?> getClass() {
//		this.getClass().
//		
//		return null;
//		
//	}
}

