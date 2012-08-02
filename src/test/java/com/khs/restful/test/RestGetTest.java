package com.khs.restful.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.khs.restful.IResponse;
import com.khs.restful.JsonResponse;
import com.khs.restful.Response;
import com.khs.restful.RestClient;
import com.khs.restful.RestTemplate;
import com.khs.restful.RestfulException;
import com.khs.restful.http.Delete;

public class RestGetTest {

	private static final String URL = "http://sherpa.keyholekc.com/sherpa?endpoint=StockService&action=quotes";
	static class Stock {
		public String ticker;
		public String name;
		public String tradeDate;
		public float price;
		public float dividendYield;
		public float pe;
	}
	
	
	@Test
	public void test() {
		RestTemplate template = new RestTemplate();
		JsonResponse response;
		try {
			response = template.json(URL);
			assertNotNull(response);
			assertNotNull(response.getResponseText());
			System.out.println(response.getResponseText());
		} catch (RestfulException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSerialize() {
		//Stock quote = new Stock();
		RestTemplate template = new RestTemplate();
		Stock[] quote;
		try {
			quote = template.json(URL, Stock[].class);
			assertNotNull(quote);
		} catch (RestfulException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}				
	}

	@Test
	public void testDelete() {
		RestTemplate template = new RestTemplate();
		try {
			Response response = template.text(URL, new Delete());
			assertNotNull(response);
		} catch (RestfulException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

}
