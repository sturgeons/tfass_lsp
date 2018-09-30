package com.expressway.bill.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final String URL_BASE = "/printService/%s?meta=%s&data=%s&params=%s";

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public void testApp() throws UnsupportedEncodingException {
		System.out.println(String.format(URL_BASE, "123", URLEncoder.encode("{}", "UTF-8"),
				URLEncoder.encode("{}", "UTF-8"), URLEncoder.encode("{}", "UTF-8")));
	}
}
