package com.fxtech.ldplatform.zp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.zp.mappers.ZPinstorehisMapper;

@Service("ZPinstorehisService")
public class ZPinstorehisService {
	private @Autowired ZPinstorehisMapper zpinstorehismapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return zpinstorehismapper.find(params);
	}
}
