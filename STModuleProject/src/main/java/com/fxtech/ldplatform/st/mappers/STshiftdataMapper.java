package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STshiftdataMapper {
	@Select("select * from V_ACC_SACTUAL where line = #{LINE} and op = #{OP}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
