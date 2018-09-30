package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STworkminuteMapper {
	@Select("select * from v_work_minute")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
