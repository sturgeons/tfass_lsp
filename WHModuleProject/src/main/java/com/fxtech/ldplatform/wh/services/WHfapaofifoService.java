package com.fxtech.ldplatform.wh.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.wh.mappers.WHfapaofifoMapper;

@Service("WHfapaofifoService")
public class WHfapaofifoService {
	private @Autowired WHfapaofifoMapper whfapaofifoMapper;

	public List<LinkedHashMap<String, ?>> find(Map<String, ?> params) {
		return whfapaofifoMapper.find();
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		whfapaofifoMapper.del(attrs);
		return new FeedBackMessage(whfapaofifoMapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}
}
