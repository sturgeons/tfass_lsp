package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SToeedataMapper {
	@Select("SELECT min(total) total FROM ST_OEE_DATA WHERE line = #{LINE} AND op IS NOT NULL")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
