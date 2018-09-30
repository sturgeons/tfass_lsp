package com.fxtech.ldplatform.st.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STlastpartnoMapper;

@Service("STlastpartnoService")
public class STlastpartnoService {
	private @Autowired STlastpartnoMapper stlastpartnoMapper;

	public Object find(Map<String, ?> params) {
		return stlastpartnoMapper.find(params);
	}
}
