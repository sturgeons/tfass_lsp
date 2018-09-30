package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STusedpercentMapper;

@Service("STusedpercentService")
public class STusedpercentService {
	private @Autowired STusedpercentMapper stusedpercentMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stusedpercentMapper.find(params);
	}
}
