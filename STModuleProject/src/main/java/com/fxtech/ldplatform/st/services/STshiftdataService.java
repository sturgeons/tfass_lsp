package com.fxtech.ldplatform.st.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STshiftdataMapper;

@Service("STshiftdataService")
public class STshiftdataService {
	private @Autowired STshiftdataMapper stshiftdataMapper;

	Logger log = Logger.getLogger(STshiftdataService.class);

	public Object find(Map<String, ?> params) {

		log.info("STshiftdataService Invoke.");

		List<Map<String, ?>> list = stshiftdataMapper.find(params);

		log.info(list.size());

		return list;
	}
}
