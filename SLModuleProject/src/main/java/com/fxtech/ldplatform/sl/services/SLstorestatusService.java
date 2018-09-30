package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.sl.mappers.SLstorestatusMapper;

@Service("SLstorestatusService")
public class SLstorestatusService {
	private @Autowired SLstorestatusMapper slstorestatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return slstorestatusmapper.find(params);
	}
}
