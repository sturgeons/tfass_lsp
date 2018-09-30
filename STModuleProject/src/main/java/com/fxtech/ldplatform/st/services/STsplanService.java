package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STsplanMapper;

@Service("STsplanService")
public class STsplanService {
	private @Autowired STsplanMapper stsplanMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stsplanMapper.find(params);
	}
}
