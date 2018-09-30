package com.fxtech.ldplatform.zp.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.CallbackMessage;
import com.fxtech.ldplatform.zp.mappers.ZPstoredataMapper;

@Service("ZPstoredataService")
public class ZPstoredataService {
	private @Autowired ZPstoredataMapper zpstoredatamapper;

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
		return new CallbackMessage(true, zpstoredatamapper.findStatus(params));
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
		String res = zpstoredatamapper.findInStore(params);

		if (res == null || "".equals(res)) {// 返回零件当前的状态
			if (zpstoredatamapper.inStore(params) > 0) {
				return new CallbackMessage(true, "总成 [" + params.get("content") + "] 已完成扫描");
			}
			return new CallbackMessage(false, "缺陷代码无效");
		}
		return new CallbackMessage(false, res);
	}
}
