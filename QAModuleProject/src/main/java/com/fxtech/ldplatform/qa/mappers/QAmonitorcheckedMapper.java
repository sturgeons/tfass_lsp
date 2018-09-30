package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface QAmonitorcheckedMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE qa_result  WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> attrs);
	
	@Insert("INSERT INTO qa_result (em_id, quality_id, result_val) VALUES (#{EM_ID}, #{ID}, #{RESULT_VAL})")
	public int insert(Map<String, ?> attrs);
}
