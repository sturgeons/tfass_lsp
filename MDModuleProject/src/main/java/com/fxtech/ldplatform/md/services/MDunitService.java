package com.fxtech.ldplatform.md.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.md.mappers.MDunitMapper;

@Service("MDunitService")
public class MDunitService {
	private @Autowired MDunitMapper mdunitMapper;

	public List<LinkedHashMap<String, ?>> find(Map<String, ?> params) {
		return mdunitMapper.find();
	}
}
