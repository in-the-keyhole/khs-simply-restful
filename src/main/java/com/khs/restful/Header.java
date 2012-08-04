package com.khs.restful;

import java.util.Map;

import com.khs.restful.client.NameValueList;

public class Header extends NameValueList {
	
	public Header() {
		super();
	}
	
	public Header(String value) {
		super(value);
	}
	
	public Header(String name, String value) throws RestfulException {
		super(name, value);
	}
	
	public Header(Map<String, String> aMap) throws RestfulException {
		super(aMap);
	}
}
