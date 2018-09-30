package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAgatherMapper;

@Service("QAgatherService")
public class QAgatherService {
	private @Autowired QAgatherMapper qagathermapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qagathermapper.find(params);
	}
}
