package com.fxtech.ldplatform.fp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.fp.mappers.FPstorestatusMapper;

@Service("FPstorestatusService")
public class FPstorestatusService {
	private @Autowired FPstorestatusMapper fpstorestatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return fpstorestatusmapper.find(params);
	}
}
