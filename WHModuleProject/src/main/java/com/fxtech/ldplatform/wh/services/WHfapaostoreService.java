package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHfapaostoreMapper;

@Service("WHfapaostoreService")
public class WHfapaostoreService {
	private @Autowired WHfapaostoreMapper whfapaostoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whfapaostoremapper.find(params);
	}
}
