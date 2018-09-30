package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STworkdataMapper;

@Service("STworkdataService")
public class STworkdataService {
	private @Autowired STworkdataMapper stworkdataMapper;
	
	Logger log = Logger.getLogger(STworkdataService.class);

	public List<Map<String, ?>> find(Map<String, ?> params) {
		log.info("STworkdataService Invoke.");
		
		List<Map<String, ?>> list = stworkdataMapper.find(params);
		
		log.info(list.size());
		
		return list;
	}
}
