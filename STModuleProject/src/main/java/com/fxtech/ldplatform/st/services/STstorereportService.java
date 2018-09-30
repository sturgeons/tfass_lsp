package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STstorereportMapper;

@Service("STstorereportService")
public class STstorereportService {
	private @Autowired STstorereportMapper mapper;
	
	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
	}
}
