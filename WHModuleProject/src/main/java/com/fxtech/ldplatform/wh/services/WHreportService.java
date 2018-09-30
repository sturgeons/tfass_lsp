package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHreportMapper;

@Service("WHreportService")
public class WHreportService {
	private @Autowired WHreportMapper whreportmapper;

	public List<Map<String, ?>> findSimple(Map<String, ?> params) {
		return whreportmapper.findSimple(params);
	}

	public List<Map<String, ?>> findFull(Map<String, ?> params) {
		return whreportmapper.findFull(params);
	}
}
