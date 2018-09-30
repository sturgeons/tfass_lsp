package com.fxtech.ldplatform.md.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDemqualityMapper;

@Service("MDemqualityService")
public class MDemqualityService {
	private @Autowired MDemqualityMapper mdemqualityMapper;

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> params) {
		return new FeedBackMessage(mdemqualityMapper.del(params) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, ?> attrs) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map[] items = mapper.readValue((String) attrs.get("PARTS"),
					mapper.getTypeFactory().constructArrayType(Map.class));

			for (Map map : items) {
				mdemqualityMapper.add(map);
			}
			return new FeedBackMessage(true);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new FeedBackMessage(false, "添加失败，请联系系统管理员");
	}
}
