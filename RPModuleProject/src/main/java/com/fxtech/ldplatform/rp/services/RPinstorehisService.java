package com.fxtech.ldplatform.rp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.rp.mappers.RPinstorehisMapper;

@Service("RPinstorehisService")
public class RPinstorehisService {
	private @Autowired RPinstorehisMapper rpinstorehismapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return rpinstorehismapper.find(params);
	}
}
