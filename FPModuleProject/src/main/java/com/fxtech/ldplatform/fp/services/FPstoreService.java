package com.fxtech.ldplatform.fp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.fp.mappers.FPstoreMapper;

@Service("FPstoreService")
public class FPstoreService {
	private @Autowired FPstoreMapper fpstoremapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return fpstoremapper.find(params);
	}
}
