package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDemployeeMapper;

@Service("MDemployeeService")
public class MDemployeeService {
	private @Autowired MDemployeeMapper mdemployeeMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdemployeeMapper.find(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> params) {
		return new FeedBackMessage(mdemployeeMapper.del(params) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, ?> attrs) {
		return new FeedBackMessage(mdemployeeMapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		return new FeedBackMessage(mdemployeeMapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
