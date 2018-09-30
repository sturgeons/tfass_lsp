package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QApartMapper;

@Service("QApartService")
public class QApartService {
	private @Autowired QApartMapper qapartmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qapartmapper.find(params);
	}
}
