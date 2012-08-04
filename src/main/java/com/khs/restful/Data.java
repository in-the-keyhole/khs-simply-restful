package com.khs.restful;

import java.util.Map;

import com.khs.restful.client.NameValueList;

public class Data extends NameValueList {
	
	public Data() {
		super();
	}
	
	public Data(String value) {
		super(value);
	}
	
	public Data(String name, String value) throws RestfulException {
		super(name, value);
	}
	
	public Data(Map<String, String> aMap) throws RestfulException {
		super(aMap);
	}
}
