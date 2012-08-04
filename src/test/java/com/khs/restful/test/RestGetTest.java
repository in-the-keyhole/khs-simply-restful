package com.khs.restful.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.khs.restful.Delete;
import com.khs.restful.Get;
import com.khs.restful.JsonResponse;
import com.khs.restful.TextResponse;
import com.khs.restful.RestTemplate;
import com.khs.restful.RestfulException;

public class RestGetTest {

//	private static final String URL = "http://sherpa.keyholekc.com/sherpa?endpoint=StockService&action=quotes";
	private static final String URL = "http://sherpa.keyholekc.com/sherpa";
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
			//response = template.json(URL, new Get().data("endpoint", "StockService").data("action", "quotes"));
			template.addData("endpoint", "StockService").addData("action", "quotes");
			response = template.json(URL);
			System.out.println(template.getReponse().getResponseText());
			assertTrue(response.isSuccess());
			assertNotNull(response);
		} catch (RestfulException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSerialize() {
		//Stock quote = new Stock();
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("endpoint", "StockService");
		aMap.put("action", "quotes");
		RestTemplate template = new RestTemplate();
		Stock[] quote;
		try {
			quote = template.json(URL, new Get(aMap), Stock[].class);
			System.out.println(template.getReponse().getResponseText());
			assertTrue(template.getReponse().isSuccess());
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
			TextResponse response = template.text(URL, new Delete());
			System.out.println(template.getReponse().getResponseText());
//			assertTrue(template.getReponse().isSuccess());
			assertNotNull(response);
		} catch (RestfulException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

}
