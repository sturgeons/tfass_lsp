package com.fxtech.ldplatform.fp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.fp.mappers.FPpartMapper;

@Service("FPpartService")
public class FPpartService {
	private @Autowired FPpartMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
