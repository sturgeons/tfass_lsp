package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STexitstoreMapper;

@Service("STexitstoreService")
public class STexitstoreService {
	private @Autowired STexitstoreMapper stexitstoreMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stexitstoreMapper.find(params);
	}
}
