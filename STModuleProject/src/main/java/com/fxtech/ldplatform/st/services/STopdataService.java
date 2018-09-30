package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STopdataMapper;

@Service("STopdataService")
public class STopdataService {
	private @Autowired STopdataMapper stopdataMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stopdataMapper.find(params);
	}
}
