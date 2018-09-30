package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STstopeventMapper;

@Service("STstopeventService")
public class STstopeventService {
	private @Autowired STstopeventMapper ststopeventMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return ststopeventMapper.find();
	}
}
