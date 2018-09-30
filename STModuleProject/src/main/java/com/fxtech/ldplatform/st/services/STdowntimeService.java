package com.fxtech.ldplatform.st.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STdowntimeMapper;

@Service("STdowntimeService")
public class STdowntimeService {
	private @Autowired STdowntimeMapper stdowntimeMapper;

	public Object find(Map<String, ?> params) {
		return stdowntimeMapper.find(params);
	}
}
