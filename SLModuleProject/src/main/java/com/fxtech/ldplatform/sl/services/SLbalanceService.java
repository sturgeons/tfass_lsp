package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.sl.mappers.SLbalanceMapper;

@Service("SLbalanceService")
public class SLbalanceService {
	private @Autowired SLbalanceMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
