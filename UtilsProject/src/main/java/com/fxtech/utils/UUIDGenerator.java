package com.fxtech.utils;

import java.util.UUID;

/**
 * UUID 生成工具
 * 
 * @author ajaxfan
 */
public abstract class UUIDGenerator {
	public static synchronized String random() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
