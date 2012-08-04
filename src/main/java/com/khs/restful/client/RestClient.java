package com.khs.restful.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;

import com.khs.restful.RestfulException;

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
			InitalizeResponse();
			BaseMethod baseMethod = setRequestData(method);
			HttpResponse httpResponse = client.execute(baseMethod.getMethod());
			retrieveStatus(httpResponse);
			retrieveResponse(httpResponse);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to retrieve service from "
					+ method.getUrl(), e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to retrieve service from "
					+ method.getUrl(), e);
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}
		return response;
	}

	private BaseMethod setRequestData(IMethod method) {
		BaseMethod baseMethod = (BaseMethod) method;
		baseMethod.setHeaders();
		baseMethod.setEntity();
		return baseMethod;
	}

	private void InitalizeResponse() throws RestfulException {
		try {
			// responseClass = this.getGenericClass();
			// System.out.println(responseClass);
			response = responseClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to create new instance of "
					+ responseClass.getClass(), e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Failed to create new instance of "
					+ responseClass.getClass(), e);
		}
	}

	private void retrieveResponse(HttpResponse httpResponse)
			throws IllegalStateException, IOException, RestfulException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(httpResponse.getEntity().getContent())));

		StringBuilder output = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			output.append(line);
		}
		
		if ( br != null) {
			br.close();
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
