package com.expressway.excelproject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void test() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("key", "123");
		
		
		map.put("key", "456");
		
		System.out.println(map.get("key"));
	}
}
