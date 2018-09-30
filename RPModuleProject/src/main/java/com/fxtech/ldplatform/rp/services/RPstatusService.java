package com.fxtech.ldplatform.rp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.rp.mappers.RPstatusMapper;

@Service("RPstatusService")
public class RPstatusService {
	private @Autowired RPstatusMapper rpstatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return rpstatusmapper.find(params);
	}
}
