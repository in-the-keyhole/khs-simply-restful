package com.khs.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;

import com.khs.restful.http.IMethod;

public class RestClient<T extends IResponse> {

	private DefaultHttpClient client;
	private T response = null;
	private Class<T> responseClass;

	public RestClient(Class<T> clazz) {
		client = new DefaultHttpClient();
		responseClass = clazz;
	}

	public T execute(IMethod method) throws RestfulException {
		try {
			HttpResponse httpResponse = client.execute(method.getMethod());
			retrieveResponse(httpResponse);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to retrieve service from " + method.getUrl(), e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to retrieve service from " + method.getUrl(), e);
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}
		return response;
	}

	private Class<T> getGenericClass() {
		Class<T> result = null;
		Type type = this.getClass().getGenericSuperclass();

		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] fieldArgTypes = pt.getActualTypeArguments();
			result = (Class<T>) fieldArgTypes[0];
		}

		return result;
	}

	private void InitalizeResponse() throws RestfulException {
		try {
			// responseClass = this.getGenericClass();
			// System.out.println(responseClass);
			response = responseClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to create new instance of " + responseClass.getClass(), e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to create new instance of " + responseClass.getClass(), e);
		}
	}

	private void retrieveResponse(HttpResponse httpResponse) 
			throws IllegalStateException, IOException, RestfulException {
		InitalizeResponse();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(httpResponse.getEntity().getContent())));

		StringBuffer output = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			output.append(line);
		}
		response.setResponseText(output.toString());
	}

	private void retrieveStatus(HttpResponse httpResponse) {
		if (httpResponse != null
				&& (httpResponse.getStatusLine().getStatusCode() == 200 || httpResponse
						.getStatusLine().getStatusCode() == 201)) {
			response.setSuccess(true);
		}

	}
}
