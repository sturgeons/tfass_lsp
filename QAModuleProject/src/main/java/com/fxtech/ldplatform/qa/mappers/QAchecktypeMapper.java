package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface QAchecktypeMapper {
	@Select("SELECT check_type FROM md_quality GROUP BY check_type")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
