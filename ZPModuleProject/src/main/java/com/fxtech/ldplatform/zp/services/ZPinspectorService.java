package com.fxtech.ldplatform.zp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.zp.mappers.ZPinspectorMapper;

@Service("ZPinspectorService")
public class ZPinspectorService {
	private @Autowired ZPinspectorMapper zpinspectormapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return zpinspectormapper.find(params);
	}
}
