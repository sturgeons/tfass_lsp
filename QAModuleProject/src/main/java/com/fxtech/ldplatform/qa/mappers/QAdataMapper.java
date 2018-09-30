package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface QAdataMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE qa_result  WHERE sysid = #{SYSID} AND status = 0")
	public int del(Map<String, ?> attrs);

	@Insert("INSERT INTO qa_result (em_id, quality_id, result_val, shift, created)  "
			+ " SELECT #{EM_ID}, #{ID}, #{RESULT_VAL}, #{SHIFT_NAME}, to_date(#{CREATED}, 'yyyy-mm-dd') "
			+ " FROM dual WHERE NOT EXISTS ("
			+ " SELECT sysid FROM qa_result WHERE sysid = #{SYSID} AND status = 1)")
	public int insert(Map<String, ?> attrs);
}
