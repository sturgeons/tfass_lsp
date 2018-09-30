package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAreportMapper;

@Service("QAreportService")
public class QAreportService {
	private @Autowired QAreportMapper qareportMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qareportMapper.find(params);
	}
}
