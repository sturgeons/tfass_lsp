package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHfapaopartMapper;

@Service("WHfapaopartService")
public class WHfapaopartService {
	private @Autowired WHfapaopartMapper whfapaopartMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whfapaopartMapper.find(params);
	}
}
