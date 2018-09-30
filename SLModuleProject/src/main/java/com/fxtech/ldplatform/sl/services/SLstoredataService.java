package com.fxtech.ldplatform.sl.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fxtech.ldplatform.api.messages.CallbackMessage;
import com.fxtech.ldplatform.sl.mappers.SLstoredataMapper;

@Service("SLstoredataService")
public class SLstoredataService {
	private @Autowired SLstoredataMapper slstoredatamapper;

	/**
	 *入库
	 * 
	 * @param params
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Transactional(rollbackFor = Exception.class)
	public CallbackMessage inStore(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		// 判断条码是否符合规则
		String res = slstoredatamapper.findInStore(params);

		if (res == null || "".equals(res)) {// 返回零件当前的状态
			if (slstoredatamapper.inStore(params) > 0) {
				return new CallbackMessage(true, "裁片 " + params.get("qadno") + " 已入库 " + params.get("count") + " -- 箱号: "+ params.get("boxno"));
			}
			return new CallbackMessage(false, "裁片入库失败，无效的条码或箱号信息");
		}
		return new CallbackMessage(false, res);
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
	public CallbackMessage outStore(Map<String, ?> params) throws JsonParseException, JsonMappingException, IOException {
		// 判断条码是否符合规则
		String res = slstoredatamapper.findOutStore(params);

		if (res == null || "".equals(res)) {// 返回零件当前的状态
			if (slstoredatamapper.outStore(params) > 0) {
				return new CallbackMessage(true, "裁片零件完成出库");
			}
			return new CallbackMessage(false, "无效条码或违反先入先出");
		}
		return new CallbackMessage(false, res);
	}
}
