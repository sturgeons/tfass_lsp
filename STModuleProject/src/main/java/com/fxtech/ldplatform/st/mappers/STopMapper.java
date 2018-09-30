package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STopMapper {
	@Select("SELECT op FROM v_acc_op WHERE  db = #{DBNAME} and line = #{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
	

	@Select("SELECT op FROM v_acc_op WHERE line = #{LINE} order by op")
	public List<Map<String, ?>> findAll(Map<String, ?> params);
}
