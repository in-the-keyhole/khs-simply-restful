package com.khs.restful.json;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

import com.google.gson.Gson;

public class GsonSerializer<T> implements IJsonSerializer<T> {

	private Class<T> jsonObject;
	
	public GsonSerializer(Class<T> clazz) {
		jsonObject = clazz;
	}
		
	@Override
	public T serializer(String json) {
		Gson gson = new Gson();
		
		return gson.fromJson(json, jsonObject);
		
		//return null;
	}

}
