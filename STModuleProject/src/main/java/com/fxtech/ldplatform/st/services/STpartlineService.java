package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STpartlineMapper;

@Service("STpartlineService")
public class STpartlineService {
	private @Autowired STpartlineMapper stpartlineMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stpartlineMapper.find(params);
	}
}
