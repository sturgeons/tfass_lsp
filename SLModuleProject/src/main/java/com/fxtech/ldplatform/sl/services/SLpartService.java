package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.sl.mappers.SLpartMapper;

@Service("SLpartService")
public class SLpartService {
	private @Autowired SLpartMapper slpartmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return slpartmapper.find(params);
	}
}
