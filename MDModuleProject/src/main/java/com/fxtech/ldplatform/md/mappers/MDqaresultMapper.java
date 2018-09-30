package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDqaresultMapper {
	@Select("SELECT * FROM qa_result")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM qa_result WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO qa_result (em_id, quality_id, result_val, created) "
			+ " SELECT #{EM_ID}, #{QUALITY_ID}, #{RESULT_VAL}, #{CREATED}" + " FROM dual")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE qa_result SET em_id = #{EM_ID}, quality_id = #{QUALITY_ID}, result_val = #{RESULT_VAL} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
