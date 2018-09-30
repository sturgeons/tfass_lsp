package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STinstorehisMapper;

@Service("STinstorehisService")
public class STinstorehisService {
	private @Autowired STinstorehisMapper stinstorehisMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stinstorehisMapper.find(params);
	}
}
