package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STpartnoMapper;

@Service("STpartnoService")
public class STpartnoService {
	private @Autowired STpartnoMapper stpartnoMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stpartnoMapper.find(params);
	}
}
