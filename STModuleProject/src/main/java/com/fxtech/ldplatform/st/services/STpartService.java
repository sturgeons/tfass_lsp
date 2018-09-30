package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STpartMapper;

@Service("STpartService")
public class STpartService {
	private @Autowired STpartMapper stpartMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stpartMapper.find(params);
	}
}
