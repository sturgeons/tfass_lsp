package com.fxtech.ldplatform.md.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.mappers.MDshiftMapper;

@Service("MDshiftService")
public class MDshiftService {
	private @Autowired MDshiftMapper mdshiftMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mdshiftMapper.find();
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage del(Map<String, ?> params) {
		return new FeedBackMessage(mdshiftMapper.del(params) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage add(Map<String, Object> attrs) {
		attrs.put("SHIFT_BEGIN",
				adpaterLength(attrs.get("BEGIN_HOUR")) + ":" + adpaterLength(attrs.get("BEGIN_MINUTE")));
		attrs.put("SHIFT_END", adpaterLength(attrs.get("END_HOUR")) + ":" + adpaterLength(attrs.get("END_MINUTE")));

		return new FeedBackMessage(mdshiftMapper.add(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	@Transactional(rollbackFor = Exception.class)
	public FeedBackMessage update(Map<String, Object> attrs) {
		attrs.put("SHIFT_BEGIN",
				adpaterLength(attrs.get("BEGIN_HOUR")) + ":" + adpaterLength(attrs.get("BEGIN_MINUTE")));
		attrs.put("SHIFT_END", adpaterLength(attrs.get("END_HOUR")) + ":" + adpaterLength(attrs.get("END_MINUTE")));

		return new FeedBackMessage(mdshiftMapper.update(attrs) > 0, "指令未被执行，请查看系统日志了解详细信息.");
	}

	private String adpaterLength(Object obj) {
		String res = (String) obj;
		StringBuilder pre = new StringBuilder();
		int len = 2 - res.length();

		for (int i = 0; i < len; i++) {
			pre.append("0");
		}
		return pre.toString() + res;
	}
}
