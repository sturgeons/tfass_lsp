package com.fxtech.ldplatform.wh.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.wh.mappers.WHfapaotofengpiMapper;

@Service("WHfapaotofengpiService")
public class WHfapaotofengpiService {
	private @Autowired WHfapaotofengpiMapper whfapaotofengpimapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return whfapaotofengpimapper.find(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		whfapaotofengpimapper.del(attrs);
		return new FeedBackMessage(whfapaotofengpimapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
