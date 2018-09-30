package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDqadMapper {
	@Select("SELECT * FROM md_qad order by qadno")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_qad WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_qad (sysid, qadno, jp, pretime) " + " SELECT #{SYSID}, #{QADNO}, #{JP}, #{PRETIME} "
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM md_qad WHERE qadno = #{QADNO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_qad SET qadno = #{QADNO}, jp = #{JP}, pretime = #{PRETIME} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
