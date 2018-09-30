package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STpartactualMapper;

@Service("STpartactualService")
public class STpartactualService {
	private @Autowired STpartactualMapper stpartactualMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stpartactualMapper.find(params);
	}
}
