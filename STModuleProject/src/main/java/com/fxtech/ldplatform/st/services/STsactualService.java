package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STsactualMapper;

@Service("STsactualService")
public class STsactualService {
	private @Autowired STsactualMapper stsactualMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stsactualMapper.find(params);
	}
}
