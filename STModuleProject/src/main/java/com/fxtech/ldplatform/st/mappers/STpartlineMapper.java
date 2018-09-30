package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STpartlineMapper {
	@Select("SELECT * FROM v_ld_partno_to_line")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
