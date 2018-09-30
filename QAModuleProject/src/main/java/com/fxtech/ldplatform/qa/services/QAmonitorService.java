package com.fxtech.ldplatform.qa.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.qa.mappers.QAmonitorMapper;

@Service("QAmonitorService")
public class QAmonitorService {
	private @Autowired QAmonitorMapper qamonitorMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qamonitorMapper.find(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<String> ids = mapper.readValue((String) attrs.get("IDS"), List.class);

		for (String id : ids) {
			qamonitorMapper.update(id);
		}
		return new FeedBackMessage(true);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> attrs) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<String> ids = mapper.readValue((String) attrs.get("IDS"), List.class);

		for (String id : ids) {
			qamonitorMapper.remove(id);
		}
		return new FeedBackMessage(true);
	}
}
