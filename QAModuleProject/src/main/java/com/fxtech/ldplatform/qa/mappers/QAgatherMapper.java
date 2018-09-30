package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface QAgatherMapper {
	@Select("SELECT line FROM v_quality_line")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
