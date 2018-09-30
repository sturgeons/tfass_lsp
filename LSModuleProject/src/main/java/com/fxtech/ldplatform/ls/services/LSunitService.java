package com.fxtech.ldplatform.ls.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.ls.mappers.LSunitMapper;

@Service("LSunitService")
public class LSunitService {
	private @Autowired LSunitMapper mapper;

	public List<LinkedHashMap<String, ?>> find(Map<String, ?> params) {
		return mapper.find();
	}
}
	