package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.SToutstorehisMapper;

@Service("SToutstorehisService")
public class SToutstorehisService {
	private @Autowired SToutstorehisMapper stoutstorehisMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stoutstorehisMapper.find(params);
	}
}
