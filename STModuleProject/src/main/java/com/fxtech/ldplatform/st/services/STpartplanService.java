package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STpartplanMapper;

@Service("STpartplanService")
public class STpartplanService {
	private @Autowired STpartplanMapper stpartplanMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stpartplanMapper.find(params);
	}
}
