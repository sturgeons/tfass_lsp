package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STplanMapper {
	@Select("select * from V_ACC_PLAN where line = #{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
