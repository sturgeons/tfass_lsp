package com.fxtech.ldplatform.zp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.zp.mappers.ZPstatusMapper;

@Service("ZPstatusService")
public class ZPstatusService {
	private @Autowired ZPstatusMapper zpstatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return zpstatusmapper.find(params);
	}
}
