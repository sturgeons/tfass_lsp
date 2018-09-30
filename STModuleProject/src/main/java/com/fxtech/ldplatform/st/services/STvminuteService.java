package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STvminuteMapper;

@Service("STvminuteService")
public class STvminuteService {
	private @Autowired STvminuteMapper stvminuteMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stvminuteMapper.find(params);
	}
}
