package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDqualityMapper;

@Service("MDqualityService")
public class MDqualityService {
	private @Autowired MDqualityMapper mdqualityMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdqualityMapper.find(params);
	}

	public FeedBackMessage findById(Map<String, ?> params) {
		int res = mdqualityMapper.findById(params);
		return new FeedBackMessage(res == 0, "该项目已有历史数据, 不允许删除?");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> params) {
		return new FeedBackMessage(mdqualityMapper.del(params) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, ?> attrs) {
		return new FeedBackMessage(mdqualityMapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		return new FeedBackMessage(mdqualityMapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
