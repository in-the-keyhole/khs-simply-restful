package com.khs.restful.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;

import com.khs.restful.Data;
import com.khs.restful.Header;
import com.khs.restful.RestfulException;
import com.khs.restful.system.RequestType;

public abstract class BaseMethod implements IMethod {

	private IRequest request;
	private HttpUriRequest method;
	private Data data;
	private Header header;

	public BaseMethod(RequestType type) {
		data = new Data();
		header = new Header();
		InitializeRequestType(type);
	}

	public IMethod data(Map<String, String> aMap) throws RestfulException {
		data = new Data(aMap);
		return this;
	}

	public IMethod data(String name, String value) throws RestfulException {
		data.add(name, value);
		return this;
	}
	
	public IMethod header(Map<String, String> aMap) throws RestfulException {
		header = new Header(aMap);
		return this;
	}

	public IMethod header(String name, String value) throws RestfulException {
		header.add(name, value);
		return this;
	}

	protected Data getData() {
		return data;
	}
	
	protected Header getHeader() {
		return header;
	}
	
	protected IRequest getRequest() {
		return request;
	}

	protected HttpUriRequest getMethod() {
		return method;
	}
	
	protected void setHeaders() {
		for (NameValuePair aPair : header.getDataPairs()) {
			getMethod().setHeader(aPair.getName(), aPair.getValue());			
		}
	}
	
	protected void setEntity() {		
	}

	protected void InitializeRequestType(RequestType type) {
		switch (type) {
		case JSON:
			request = new JsonRequest();
			break;
		case TEXT:
			request = new TextRequest();
			break;
		case XML:
			request = new XmlRequest();
			break;
		default:
			request = new TextRequest();
		}
	}

	protected void setContentType() {
	}
	
	protected void setData(Data data) {
		this.data = data;
	}
	
	protected void setHeader(Header header) {
		this.header = header;
	}

	protected void setMethod(HttpUriRequest method) {
		this.method = method;
	}

	@Override
	public void setMethodValues(String url, RequestType type, Header header, Data data) throws RestfulException {
		if ( data != null) {
			setData(data);
		}
		if ( header != null) {
			setHeader(header);
		}
		setURI(url);
		setRequestType(type);
	}

	@Override
	public void setRequestType(RequestType type) {
		InitializeRequestType(type);
	}

	public String getUrl() {
		return method.getURI().toString();
	}

//   @Override
	protected void setURI(String url) throws RestfulException {
		try {
			setURI(new URI(url));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Invalid url", e);
		}
	}
	
	protected abstract void setURI(URI uri) throws RestfulException;

    protected URI initUri(URI uri)  throws RestfulException {    	
    	try {
        	URIBuilder builder = new URIBuilder(uri);
        	
        	for (NameValuePair pair : getData().getDataPairs()) {
				builder.addParameter(pair.getName(), pair.getValue());
			}
			return builder.build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestfulException("Url failed to build.", e);
		}
    }

}
