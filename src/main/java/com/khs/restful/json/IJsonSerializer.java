package com.khs.restful.json;

public interface IJsonSerializer<T> {
	public T serializer(String json);
}
