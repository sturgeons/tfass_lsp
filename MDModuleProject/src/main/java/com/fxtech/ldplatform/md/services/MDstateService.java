package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDstateMapper;

@Service("MDstateService")
public class MDstateService {
	private @Autowired MDstateMapper mdstateMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdstateMapper.find();
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> params) {
		return new FeedBackMessage(mdstateMapper.del(params) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, ?> attrs) {
		return new FeedBackMessage(mdstateMapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		return new FeedBackMessage(mdstateMapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
