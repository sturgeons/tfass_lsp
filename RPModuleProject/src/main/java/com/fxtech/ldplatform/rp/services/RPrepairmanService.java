package com.fxtech.ldplatform.rp.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.api.messages.CallbackMessage;
import com.fxtech.ldplatform.rp.mappers.RPrepairmanMapper;

@Service("RPrepairmanService")
public class RPrepairmanService {
	private @Autowired RPrepairmanMapper rprepairmanmapper;

	public CallbackMessage find(Map<String, ?> params) {
		if (rprepairmanmapper.find(params).size() > 0) {
			return new CallbackMessage(true);
		}
		return new CallbackMessage(false, "无效的返修员编号");
	}
}
