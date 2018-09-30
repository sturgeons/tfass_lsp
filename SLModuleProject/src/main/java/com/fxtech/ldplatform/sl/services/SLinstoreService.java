package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.sl.mappers.SLinstoreMapper;

@Service("SLinstoreService")
public class SLinstoreService {
	private @Autowired SLinstoreMapper slinstoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return slinstoremapper.find(params);
	}
}
