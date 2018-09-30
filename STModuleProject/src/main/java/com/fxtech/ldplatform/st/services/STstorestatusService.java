package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STstorestatusMapper;

@Service("STstorestatusService")
public class STstorestatusService {
	private @Autowired STstorestatusMapper ststorestatusMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return ststorestatusMapper.find(params);
	}
}
