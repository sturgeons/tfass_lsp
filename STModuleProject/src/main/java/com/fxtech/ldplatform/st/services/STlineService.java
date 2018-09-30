package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STlineMapper;

@Service("STlineService")
public class STlineService {
	private @Autowired STlineMapper stlineMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stlineMapper.find(params);
	}
	
	public List<Map<String, ?>> findAll(Map<String, ?> params) {
		return stlineMapper.findAll();
	}
}
