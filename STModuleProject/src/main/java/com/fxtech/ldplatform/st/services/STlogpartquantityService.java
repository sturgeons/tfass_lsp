package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STlogpartquantityMapper;

@Service("STlogpartquantityService")
public class STlogpartquantityService {
	private @Autowired STlogpartquantityMapper stlogpartquantityMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stlogpartquantityMapper.find(params);
	}
}
