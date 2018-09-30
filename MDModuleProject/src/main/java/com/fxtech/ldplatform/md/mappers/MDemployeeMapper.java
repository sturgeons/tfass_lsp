package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface MDemployeeMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM md_employee WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_employee (sysid, em_name, em_no, em_monitor) " + " SELECT #{SYSID}, #{EM_NAME}, #{EM_NO}, #{EM_MONITOR} "
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM md_employee WHERE em_no = #{EM_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_employee SET em_name = #{EM_NAME}, em_no = #{EM_NO}, em_monitor = #{EM_MONITOR} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
