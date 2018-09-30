package com.fxtech.ldplatform.md.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface MDplanMapper {
	@Delete("DELETE FROM md_insplan WHERE plan_date = trunc(f_workbegin()) and line = #{line}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_insplan (sysid, line, shifts, partno, plan_count, color_hex, qadno, is_force) "
			+ " SELECT sys_guid(), #{line}, #{shifts}, #{partno}, #{plan_count}, #{color_hex}, #{qadno}, #{is_force}" + " FROM dual")
	public int add(Map<String, ?> attrs);
}
