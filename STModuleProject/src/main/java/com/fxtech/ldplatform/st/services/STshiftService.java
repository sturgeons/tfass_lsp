package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STshiftMapper;

@Service("STshiftService")
public class STshiftService {
	private @Autowired STshiftMapper stshiftMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stshiftMapper.find(params);
	}
}
