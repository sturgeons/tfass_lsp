package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDdictionaryMapper;

@Service("MDdictionaryService")
public class MDdictionaryService {
	private @Autowired MDdictionaryMapper mddictionaryMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mddictionaryMapper.find(params);
	}

	@CacheEvict(value = "fx-tech-caches", key = "1025")
	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, ?> attrs) {
		return new FeedBackMessage(mddictionaryMapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Cacheable(value = "fx-tech-caches", key = "1025")
	public String findByKey(String key) {
		return mddictionaryMapper.findByKey(key);
	}
}
