package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDsliceprogMapper {
	@Select("SELECT * FROM cut.md_slice_prog ORDER BY prog_no")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM cut.md_slice_prog WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_prog (prog_no, remark) " 
	        + " SELECT upper(#{PROG_NO}), #{REMARK}  FROM dual" 
	        + " WHERE not exists (SELECT sysid FROM cut.md_slice_prog WHERE prog_no = #{PROG_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_prog SET "
			+ "    prog_no = upper(#{PROG_NO}), remark = #{REMARK}"
			+ "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
