package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDinspectorMapper {
	@Select("SELECT * FROM wh.md_inspector")
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM wh.md_inspector WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO wh.md_inspector (sysid, inspector_name, inspector_no) " + " SELECT #{SYSID}, #{INSPECTOR_NAME}, #{INSPECTOR_NO} "
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM wh.md_inspector WHERE inspector_no = #{INSPECTOR_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE wh.md_inspector SET inspector_name = #{INSPECTOR_NAME}, inspector_no = #{INSPECTOR_NO} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
