package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDswspatternMapper {
	@Select("SELECT * FROM wh.md_sws_pattern order by prodtype")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM wh.md_sws_pattern WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO wh.md_sws_pattern (sysid, prodtype, snpattern) " + " "
			+ "SELECT #{SYSID}, #{PRODTYPE}, #{SNPATTERN} " + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM wh.md_sws_pattern WHERE prodtype = #{PRODTYPE})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE wh.md_sws_pattern SET prodtype = #{PRODTYPE}, snpattern = #{SNPATTERN} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
