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
import com.fxtech.ldplatform.qa.mappers.QAdataMapper;

@Service("QAdataService")
public class QAdataService {
	private @Autowired QAdataMapper qadataMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return qadataMapper.find(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		ObjectMapper mapper = new ObjectMapper();
		boolean res = true;

		try {
			Map[] items = mapper.readValue((String) attrs.get("DATAS"),
					mapper.getTypeFactory().constructArrayType(Map.class));

			for (Map map : items) {
				qadataMapper.del(map);
				res = qadataMapper.insert(map) > 0;
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new FeedBackMessage(res, "数据提交失败 , 班长已确认的数据或系统异常.请刷新后再次尝试.");
	}
}
