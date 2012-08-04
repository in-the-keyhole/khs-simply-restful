package com.khs.restful.client;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.khs.restful.RestfulException;

public abstract class NameValueList {
	
	private String data = null;
	private final List<NameValuePair> pairs = new Vector<NameValuePair>();

	public NameValueList() {
		super();
	}
	
	public NameValueList(String value) {
		data = value;
	}
	
	public NameValueList(String name, String value) throws RestfulException {
		pairs.add(new NameValuePair(name, value));
	}
	
	public NameValueList(Map<String, String> aMap) throws RestfulException {
		super();
		
		Set<String> keys = aMap.keySet();
		for (String key : keys) {
			pairs.add(new NameValuePair(key, aMap.get(key)));
		}
	}
	
	public void add(String name, String value) throws RestfulException {
		if ( name == null) {
			throw new RestfulException("Name can not be null.");
		}
		pairs.add(new NameValuePair(name, value));
	}
	
	public List<NameValuePair> getDataPairs() {
		return pairs;
	}
	
	public String toString() {
		if ( data != null ) {
			return data;
		}
		StringBuilder buf = new StringBuilder();
		int i = 0;
		for (NameValuePair aPair : pairs) {
			if ( i > 0) {
				buf.append("&");
			}
			buf.append(aPair.getName());
			buf.append("=");
			buf.append(aPair.getValue());
			i++;
		}
		return buf.toString();
	}
}
