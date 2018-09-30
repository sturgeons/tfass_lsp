package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STlineMapper {
	@Select("SELECT line FROM v_acc_line WHERE db = #{DBNAME}")
	public List<Map<String, ?>> find(Map<String, ?> params);
	

	@Select("SELECT line FROM v_acc_line order by line")
	public List<Map<String, ?>> findAll();
}
