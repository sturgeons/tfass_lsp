package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDadjustreasonMapper {
	@Select("SELECT * FROM md_adjust_reason order by reason_code")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_adjust_reason WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_adjust_reason (sysid, reason_name, remark, reason_code) "
			+ " SELECT #{SYSID}, #{REASON_NAME}, #{REMARK}, #{REASON_CODE} " + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM md_adjust_reason WHERE reason_name = #{REASON_NAME} or reason_code = #{REASON_CODE})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_adjust_reason SET reason_name = #{REASON_NAME}, remark = #{REMARK}, reason_code = #{REASON_CODE} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
