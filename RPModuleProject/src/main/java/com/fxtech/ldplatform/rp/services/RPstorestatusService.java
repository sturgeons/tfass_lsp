package com.fxtech.ldplatform.rp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.rp.mappers.RPstorestatusMapper;

@Service("RPstorestatusService")
public class RPstorestatusService {
	private @Autowired RPstorestatusMapper rpstorestatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return rpstorestatusmapper.find(params);
	}

	public List<Map<String, ?>> query(Map<String, ?> params) {
		return rpstorestatusmapper.query(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		rpstorestatusmapper.del(attrs);
		return new FeedBackMessage(rpstorestatusmapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
