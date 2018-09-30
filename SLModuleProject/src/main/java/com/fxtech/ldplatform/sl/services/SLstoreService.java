package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.sl.mappers.SLstoreMapper;

@Service("SLstoreService")
public class SLstoreService {
	private @Autowired SLstoreMapper slstoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return slstoremapper.find(params);
	}
}
