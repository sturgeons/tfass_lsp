package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.SThplanMapper;

@Service("SThplanService")
public class SThplanService {
	private @Autowired SThplanMapper sthplanMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return sthplanMapper.find(params);
	}
}
