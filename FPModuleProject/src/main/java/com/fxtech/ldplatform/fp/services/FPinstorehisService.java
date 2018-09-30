package com.fxtech.ldplatform.fp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.fp.mappers.FPinstorehisMapper;

@Service("FPinstorehisService")
public class FPinstorehisService {
	private @Autowired FPinstorehisMapper fpinstorehismapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return fpinstorehismapper.find(params);
	}
}
