package com.fxtech.ldplatform.ls.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.ls.mappers.LSoutstorehisMapper;

@Service("LSoutstorehisService")
public class LSoutstorehisService {
	private @Autowired LSoutstorehisMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
