package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDdictionaryMapper {
	@Select("SELECT * FROM md_dictionary")
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM md_dictionary WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_dictionary (sysid, name, val, remark) "
			+ " SELECT #{SYSID}, #{NAME}, #{VAL}, #{REMARK}  FROM dual")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_dictionary SET name = #{NAME}, val = #{VAL}, remark=#{REMARK} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);

	@Select("SELECT val FROM md_dictionary WHERE name = #{key}")
	public String findByKey(String key);
}
