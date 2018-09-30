package com.fxtech.ldplatform.st.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STdownminuteMapper;

@Service("STdownminuteService")
public class STdownminuteService {
	private @Autowired STdownminuteMapper stdownminuteMapper;

	public Object find(Map<String, ?> params) {
		return stdownminuteMapper.find(params);
	}
}
