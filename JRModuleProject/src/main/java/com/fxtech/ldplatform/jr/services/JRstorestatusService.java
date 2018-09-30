package com.fxtech.ldplatform.jr.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.jr.mappers.JRstorestatusMapper;

@Service("JRstorestatusService")
public class JRstorestatusService {
	private @Autowired JRstorestatusMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
