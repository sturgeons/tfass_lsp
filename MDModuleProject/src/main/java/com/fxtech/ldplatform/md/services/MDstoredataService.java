package com.fxtech.ldplatform.md.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.CallbackMessage;
import com.fxtech.ldplatform.md.mappers.MDstoredataMapper;

@Service("MDstoredataService")
public class MDstoredataService {
	private @Autowired MDstoredataMapper mdstoredataMapper;

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
		List<Map<String, ?>> list = mdstoredataMapper.findInStore(params);

		if (list.size() > 0) {
			Map record = list.get(0);

			if (record.get("UNIT_NAME") == null || "".equals(record.get("UNIT_NAME"))) {
				return new CallbackMessage(false, "库存区已满，无法执行入库操作");
			}
			return new CallbackMessage(mdstoredataMapper.inStore(record) > 0,
					"零件 [" + record.get("QADNO") + "] 已放入库位 --- " + record.get("UNIT_NAME"),
					(String) record.get("UNIT_NAME"));
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
		List<Map<String, ?>> list = mdstoredataMapper.findOutStore(params);

		if (list.size() > 0) {
			Map record = list.get(0);

			return new CallbackMessage(mdstoredataMapper.outStore(record) > 0,
					"零件 [" + record.get("QADNO") + "] 已从库位 --- " + record.get("UNIT_NAME") + " 取出",
					(String) record.get("UNIT_NAME"));
		}
		return new CallbackMessage(false, "无效的包装条码. 或未遵照先入先出原则.");
	}
}
