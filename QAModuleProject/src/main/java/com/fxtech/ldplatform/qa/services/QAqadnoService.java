package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAqadnoMapper;

@Service("QAqadnoService")
public class QAqadnoService {
	private @Autowired QAqadnoMapper qaqadnoMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qaqadnoMapper.find(params);
	}
}
