package com.fxtech.ldplatform.rp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.rp.mappers.RPreworkreportMapper;

@Service("RPreworkreportService")
public class RPreworkreportService {
	private @Autowired RPreworkreportMapper rpreworkreportmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return rpreworkreportmapper.find(params);
	}
}
