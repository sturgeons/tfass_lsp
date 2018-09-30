package com.fxtech.ldplatform.md.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDdowntimeMapper;

@Service("MDdowntimeService")
public class MDdowntimeService {
	private @Autowired MDdowntimeMapper mddowntimeMapper;

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, ?> attrs) {
		mddowntimeMapper.add(attrs);

		return new FeedBackMessage(true, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
