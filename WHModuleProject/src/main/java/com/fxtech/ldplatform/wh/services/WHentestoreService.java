package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHentestoreMapper;

@Service("WHentestoreService")
public class WHentestoreService {
	private @Autowired WHentestoreMapper whentestoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whentestoremapper.find(params);
	}
}
