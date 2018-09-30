package com.fxtech.ldplatform.wh.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHfapaounitMapper;

@Service("WHfapaounitService")
public class WHfapaounitService {
	private @Autowired WHfapaounitMapper whfapaounitMapper;

	public List<LinkedHashMap<String, ?>> find(Map<String, ?> params) {
		return whfapaounitMapper.find();
	}
}
