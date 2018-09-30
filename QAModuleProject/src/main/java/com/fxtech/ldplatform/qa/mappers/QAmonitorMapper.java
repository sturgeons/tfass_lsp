package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface QAmonitorMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE qa_result  WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> attrs);

	@Delete("DELETE qa_result  WHERE sysid = #{id}")
	public int remove(@Param("id") String id);

	@Update("UPDATE qa_result SET status = 1 WHERE sysid = #{id}")
	public int update(@Param("id") String id);
}
