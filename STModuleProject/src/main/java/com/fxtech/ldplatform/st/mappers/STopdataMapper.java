package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STopdataMapper {
	@Select("select partno, qadno, count(ctime) total  from V_ACC_WORKDATA where line = #{LINE} and op=#{OP}  group by partno, qadno")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
