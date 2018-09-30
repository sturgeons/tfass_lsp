package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.sl.mappers.SLoutstoreMapper;

@Service("SLoutstoreService")
public class SLoutstoreService {
	private @Autowired SLoutstoreMapper sloutstoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return sloutstoremapper.find(params);
	}
}
