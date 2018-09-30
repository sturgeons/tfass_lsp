package com.fxtech.ldplatform.st.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STworkminuteMapper;

@Service("STworkminuteService")
public class STworkminuteService {
	private @Autowired STworkminuteMapper stworkminuteMapper;

	public Object find(Map<String, ?> params) {
		return stworkminuteMapper.find(params);
	}
}
