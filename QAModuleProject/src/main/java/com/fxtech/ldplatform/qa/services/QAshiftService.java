package com.fxtech.ldplatform.qa.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.qa.mappers.QAshiftMapper;

@Service("QAshiftService")
public class QAshiftService {
	private @Autowired QAshiftMapper qashiftmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qashiftmapper.find(params);
	}
}
