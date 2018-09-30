package com.fxtech.ldplatform.fp.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.fp.mappers.FPunitMapper;

@Service("FPunitService")
public class FPunitService {
	private @Autowired FPunitMapper mapper;

	public List<LinkedHashMap<String, ?>> find(Map<String, ?> params) {
		return mapper.find();
	}
}
	