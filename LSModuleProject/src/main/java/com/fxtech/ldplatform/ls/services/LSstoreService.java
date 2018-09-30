package com.fxtech.ldplatform.ls.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.ls.mappers.LSstoreMapper;

@Service("LSstoreService")
public class LSstoreService {
	private @Autowired LSstoreMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
