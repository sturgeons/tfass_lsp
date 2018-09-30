package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

public interface QAreportMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);
}
