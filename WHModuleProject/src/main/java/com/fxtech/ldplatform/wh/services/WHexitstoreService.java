package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHexitstoreMapper;

@Service("WHexitstoreService")
public class WHexitstoreService {
	private @Autowired WHexitstoreMapper whexitstoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whexitstoremapper.find(params);
	}
}
