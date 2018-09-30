package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHfapaostorestatusMapper;

@Service("WHfapaostorestatusService")
public class WHfapaostorestatusService {
	private @Autowired WHfapaostorestatusMapper whfapaostorestatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whfapaostorestatusmapper.find(params);
	}
}
