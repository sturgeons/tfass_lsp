package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.wh.mappers.WHfapaooutstorehisMapper;

@Service("WHfapaooutstorehisService")
public class WHfapaooutstorehisService {
	private @Autowired WHfapaooutstorehisMapper whfapaooutstorehismapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whfapaooutstorehismapper.find(params);
	}
}
