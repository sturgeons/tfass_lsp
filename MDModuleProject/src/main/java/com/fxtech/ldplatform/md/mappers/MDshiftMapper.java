package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDshiftMapper {
	@Select("SELECT sysid, shift_name, shift_begin, shift_end, substr(shift_begin, 0, 2) begin_hour,"
			+ " substr(shift_begin, 4, 2) begin_minute, substr(shift_end, 0, 2) end_hour,"
			+ "substr(shift_end, 4, 2) end_minute, shift_index"
			+ " from MD_SHIFT order by shift_index")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_shift WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_shift (sysid, shift_name, shift_begin, shift_end, shift_index) "
			+ " SELECT #{SYSID}, #{SHIFT_NAME}, #{SHIFT_BEGIN},  #{SHIFT_END}, #{SHIFT_INDEX}"
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM md_shift WHERE shift_name = #{SHIFT_NAME})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_shift SET shift_name = #{SHIFT_NAME}, "
			+ "shift_begin = #{SHIFT_BEGIN},"
			+ "end_hour = #{SHIFT_END},"
			+ "shift_index=#{SHIFT_INDEX} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
