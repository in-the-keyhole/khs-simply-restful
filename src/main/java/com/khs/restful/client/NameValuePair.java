package com.khs.restful.client;

import com.khs.restful.RestfulException;

public class NameValuePair implements INameValuePair {

	private String name;
	private String value;
	
	public NameValuePair(String name, String value) throws RestfulException {
		super();
		if ( name == null) {
			throw new RestfulException("Name value can not be null.");
		}
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}

}
