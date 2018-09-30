package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAlineMapper;

@Service("QAlineService")
public class QAlineService {
	private @Autowired QAlineMapper qalineMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qalineMapper.find(params);
	}
}
