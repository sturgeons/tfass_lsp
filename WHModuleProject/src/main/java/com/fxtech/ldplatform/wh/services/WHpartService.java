package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHpartMapper;

@Service("WHpartService")
public class WHpartService {
	private @Autowired WHpartMapper whpartMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whpartMapper.find(params);
	}
}