package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDdatabasesMapper {
	@Select("SELECT * FROM md_databases")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_databases WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_databases (sysid, dbname, remark) " + " SELECT #{SYSID}, #{DBNAME}, #{REMARK} "
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM md_databases WHERE dbname = #{DBNAME})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_databases SET dbname = #{DBNAME}, remark = #{REMARK} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
