package com.fxtech.ldplatform.md.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface MDemqualityMapper {
	@Delete("DELETE FROM re_quality_employee WHERE em_id = #{EM_ID} AND em_line = #{LINE}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO re_quality_employee (em_id, em_line)  VALUES (#{EM_ID}, #{LINE})")
	public int add(Map<String, ?> attrs);
}
