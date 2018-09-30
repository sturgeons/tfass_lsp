package com.fxtech.ldplatform.jr.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.jr.mappers.JRoutstorehisMapper;

@Service("JRoutstorehisService")
public class JRoutstorehisService {
	private @Autowired JRoutstorehisMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}