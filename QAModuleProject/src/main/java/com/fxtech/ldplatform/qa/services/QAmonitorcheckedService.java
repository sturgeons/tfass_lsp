package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAmonitorcheckedMapper;

@Service("QAmonitorcheckedService")
public class QAmonitorcheckedService {
	private @Autowired QAmonitorcheckedMapper qamonitorcheckedMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qamonitorcheckedMapper.find(params);
	}
}
