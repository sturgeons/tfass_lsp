package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

public interface STchartMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);
}