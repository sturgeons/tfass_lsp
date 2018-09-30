package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.md.mappers.MDstoreMapper;

@Service("MDstoreService")
public class MDstoreService {
	private @Autowired MDstoreMapper mdstoreMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdstoreMapper.find(params);
	}
}
