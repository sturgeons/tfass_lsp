package com.fxtech.utils;

/**
 * 字符串工具
 * 
 * @author Kalo
 */
public final class StringHelper {
	/**
	 * 判断字符串是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}
}
