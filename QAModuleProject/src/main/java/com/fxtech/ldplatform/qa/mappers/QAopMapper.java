package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface QAopMapper {
	@Select("SELECT op FROM md_quality WHERE line = #{LINE} AND active = '1' GROUP BY op ORDER BY op")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
