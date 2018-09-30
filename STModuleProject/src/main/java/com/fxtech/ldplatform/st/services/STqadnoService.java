package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STqadnoMapper;

@Service("STqadnoService")
public class STqadnoService {
	private @Autowired STqadnoMapper stqadnoMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stqadnoMapper.find(params);
	}
}
