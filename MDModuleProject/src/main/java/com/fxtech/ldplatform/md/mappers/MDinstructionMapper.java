package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface MDinstructionMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM md_plan WHERE plan_date = #{PLAN_DATE} AND qadno = #{QADNO} ")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_plan (qadno, plan_count, plan_date) " + " SELECT  #{QADNO}, #{PLAN_COUNT}, #{PLAN_DATE} "
			+ " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM md_plan WHERE qadno = #{QADNO} AND plan_date = #{PLAN_DATE})")
	public int add(Map<String, ?> attrs);
}
