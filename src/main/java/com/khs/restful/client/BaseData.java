package com.khs.restful.client;

public abstract class BaseData<K, V> {

	private K key;
	private V value;
	
	public BaseData(K key, V value) {
		this.key = key;
		this.value = value;
		
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}
