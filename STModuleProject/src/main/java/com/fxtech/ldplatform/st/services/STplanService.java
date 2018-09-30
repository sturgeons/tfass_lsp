package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STplanMapper;

@Service("STplanService")
public class STplanService {
	private @Autowired STplanMapper stplanMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stplanMapper.find(params);
	}
}
