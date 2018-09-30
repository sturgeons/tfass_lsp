package com.fxtech.ldplatform.fp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.fp.mappers.FPoutstorehisMapper;

@Service("FPoutstorehisService")
public class FPoutstorehisService {
	private @Autowired FPoutstorehisMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
