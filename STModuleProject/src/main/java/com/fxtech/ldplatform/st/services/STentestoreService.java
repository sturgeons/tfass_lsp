package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STentestoreMapper;

@Service("STentestoreService")
public class STentestoreService {
	private @Autowired STentestoreMapper stentestoreMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stentestoreMapper.find(params);
	}
}
