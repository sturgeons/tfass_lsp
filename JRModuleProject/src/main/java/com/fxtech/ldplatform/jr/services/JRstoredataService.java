package com.fxtech.ldplatform.jr.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.CallbackMessage;
import com.fxtech.ldplatform.jr.mappers.JRstoredataMapper;

@Service("JRstoredataService")
public class JRstoredataService {
	private @Autowired JRstoredataMapper mapper;

	/**
	 * 入库
	 * 
	 * @param params
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Transactional(rollbackFor = Exception.class)
	public CallbackMessage inStore(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		List<Map<String, ?>> list = mapper.findInStore(params);

		if (list.size() > 0) {
			Map record = list.get(0);

			return new CallbackMessage(mapper.inStore(record) > 0, "零件 [" + record.get("QADNO") + "] 入库完成");
		}
		return new CallbackMessage(false, "无效或重复的包装条码");
	}

	/**
	 * 出库
	 * 
	 * @param params
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Transactional(rollbackFor = Exception.class)
	public CallbackMessage outStore(Map<String, ?> params)
			throws JsonParseException, JsonMappingException, IOException {
		List<Map<String, ?>> list = mapper.findOutStore(params);

		if (list.size() > 0) {
			Map record = list.get(0);

			return new CallbackMessage(mapper.outStore(record) > 0,
					"零件 [" + record.get("QADNO") + "] 出库完成");
		}
		return new CallbackMessage(false, "无效条码 或 违反先入先出原则 或 不满足存放限定时间.");
	}
}
