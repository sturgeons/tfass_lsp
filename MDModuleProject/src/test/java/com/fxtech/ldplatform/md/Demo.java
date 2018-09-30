package com.fxtech.ldplatform.md;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class Demo {
	@Test
	public void time() throws ParseException {
		System.out.println(new SimpleDateFormat("HH:mm").parse("11:05"));
	}
}
