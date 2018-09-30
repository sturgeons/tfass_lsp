package com.fxtech.ldplatform.rp.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.CallbackMessage;
import com.fxtech.ldplatform.rp.mappers.RPstoredataMapper;

@Service("RPstoredataService")
public class RPstoredataService {
	private @Autowired RPstoredataMapper rpstoredatamapper;

	/**
	 * 入库前检查
	 * 
	 * @param params
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Transactional(rollbackFor = Exception.class)
	public CallbackMessage inStore(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		return new CallbackMessage(true, rpstoredatamapper.findStatus(params));
	}

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
	public CallbackMessage save(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		// 判断条码是否符合规则
		String res = rpstoredatamapper.findInStore(params);

		if (res == null || "".equals(res)) {// 返回零件当前的状态
			if (rpstoredatamapper.inStore(params) > 0) {
				return new CallbackMessage(true, "条码 [" + params.get("content") + "] 已完成扫描");
			}
			return new CallbackMessage(false, "错误的质量代码");
		}
		return new CallbackMessage(false, res);
	}
}
