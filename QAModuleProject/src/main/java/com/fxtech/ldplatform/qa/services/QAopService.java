package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAopMapper;

@Service("QAopService")
public class QAopService {
	private @Autowired QAopMapper qaopMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qaopMapper.find(params);
	}
}
