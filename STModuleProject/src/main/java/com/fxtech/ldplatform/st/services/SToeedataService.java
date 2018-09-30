package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.SToeedataMapper;

@Service("SToeedataService")
public class SToeedataService {
	private @Autowired SToeedataMapper stoeedataMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stoeedataMapper.find(params);
	}
}
