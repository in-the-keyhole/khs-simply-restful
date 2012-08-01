package com.khs.restful.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.khs.restful.IResponse;
import com.khs.restful.JsonResponse;
import com.khs.restful.RestClient;
import com.khs.restful.RestTemplate;

public class RestGetTest {

	@Test
	public void test() {
		RestTemplate template = new RestTemplate();
		JsonResponse response = template.json("http://sherpa.keyholekc.com/sherpa?endpoint=StockService&action=quotes");
		assertNotNull(response);
		assertNotNull(response.getResponseText());
		System.out.println(response.getResponseText());
	}

}
