package com.fxtech.ldplatform.zp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.zp.mappers.ZPstorestatusMapper;

@Service("ZPstorestatusService")
public class ZPstorestatusService {
	private @Autowired ZPstorestatusMapper zpstorestatusmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return zpstorestatusmapper.find(params);
	}

	public List<Map<String, ?>> query(Map<String, ?> params) {
		return zpstorestatusmapper.query(params);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		return new FeedBackMessage(zpstorestatusmapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
