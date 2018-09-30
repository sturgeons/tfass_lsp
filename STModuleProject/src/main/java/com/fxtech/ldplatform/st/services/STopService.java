package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STopMapper;

@Service("STopService")
public class STopService {
	private @Autowired STopMapper stopMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stopMapper.find(params);
	}

	public List<Map<String, ?>> findAll(Map<String, String> params) {
		if (!params.containsKey("LINE")) {
			params.put("LINE", "");
		}
		return stopMapper.findAll(params);
	}
}
