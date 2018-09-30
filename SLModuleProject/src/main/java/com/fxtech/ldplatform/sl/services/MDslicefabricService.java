package com.fxtech.ldplatform.sl.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.sl.mappers.MDslicefabricMapper;

@Service("MDslicefabricService")
public class MDslicefabricService {
	private @Autowired MDslicefabricMapper mdslicefabricmapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdslicefabricmapper.find(params);
	}

	public List<Map<String, ?>> findByQadno(Map<String, ?> params) {
		return mdslicefabricmapper.findByQadno(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> params) {
		return new FeedBackMessage(mdslicefabricmapper.del(params) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, ?> attrs) {
		return new FeedBackMessage(mdslicefabricmapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		return new FeedBackMessage(mdslicefabricmapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
