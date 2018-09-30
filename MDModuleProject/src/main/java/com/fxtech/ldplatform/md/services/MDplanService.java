package com.fxtech.ldplatform.md.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDplanMapper;

@Service("MDplanService")
public class MDplanService {
	private @Autowired MDplanMapper mdplanMapper;

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		List list = (List) params.get("datas");

		mdplanMapper.del(params);
		for (Object obj : list) {
			mdplanMapper.add((Map) obj);
		}
		return new FeedBackMessage(true, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
