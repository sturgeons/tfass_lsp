package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDinstructionMapper;

@Service("MDinstructionService")
public class MDinstructionService {
	private @Autowired MDinstructionMapper mdinstructionMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdinstructionMapper.find(params);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> attrs) {
		mdinstructionMapper.del(attrs);

		return new FeedBackMessage(true);
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		mdinstructionMapper.del(attrs);

		return new FeedBackMessage(mdinstructionMapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
