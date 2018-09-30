package com.fxtech.ldplatform.ls.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.ls.mappers.LSpartMapper;

@Service("LSpartService")
public class LSpartService {
	private @Autowired LSpartMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
