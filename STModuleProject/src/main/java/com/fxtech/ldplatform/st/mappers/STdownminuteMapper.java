package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STdownminuteMapper {
	@Select("select * from v_acc_down_minute_in_hour where line = #{LINE} and op = #{OP}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
