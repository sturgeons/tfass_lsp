package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDpartMapper {
	@Select("SELECT * FROM md_part order by partno")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_part WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_part (sysid, partno, shelf, pkg_capacity, remark, volume, attach) " + " "
			+ "SELECT #{SYSID}, #{PARTNO}, #{SHELF}, #{PKG_CAPACITY}, #{REMARK}, #{VOLUME}, #{ATTACH} " + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM md_part WHERE partno = #{PARTNO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_part SET partno = #{PARTNO}, shelf = #{SHELF}, "
			+ "pkg_capacity = #{PKG_CAPACITY}, remark = #{REMARK}, volume = #{VOLUME}, attach = #{ATTACH}"
			+ " WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
