package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAchecktypeMapper;

@Service("QAchecktypeService")
public class QAchecktypeService {
	private @Autowired QAchecktypeMapper qachecktypeMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qachecktypeMapper.find(params);
	}
}
