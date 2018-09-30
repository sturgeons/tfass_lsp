package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STemlineMapper;

@Service("STemlineService")
public class STemlineService {
	private @Autowired STemlineMapper stemlineMapper;

	public List<Map<String, ?>> findUnBindByUser(Map<String, ?> params) {
		return stemlineMapper.findUnBindByUser(params);
	}

	public List<Map<String, ?>> findBindByUser(Map<String, ?> params) {
		return stemlineMapper.findBindByUser(params);
	}
}
