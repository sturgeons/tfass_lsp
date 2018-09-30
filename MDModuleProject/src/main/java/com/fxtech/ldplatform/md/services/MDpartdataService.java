package com.fxtech.ldplatform.md.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDpartdataMapper;

@Service("MDpartdataService")
public class MDpartdataService {
	private @Autowired MDpartdataMapper mdpartdataMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage check(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		 if (mdpartdataMapper.check(params) == 0) {
			return new FeedBackMessage(false, "该物料在该线近期无拉动需求，请确认所补零件和生产线正确");
		} 
		return new FeedBackMessage(true);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		 if (mdpartdataMapper.add(params) == 0) {
			return new FeedBackMessage(false, "包装条码已存在");
		} else if (mdpartdataMapper.update(params) == 0) {
			return new FeedBackMessage(false, "无效的包装条码.");
		}
		return new FeedBackMessage(true);
	}
}
