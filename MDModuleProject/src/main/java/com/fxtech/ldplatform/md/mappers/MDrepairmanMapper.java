package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDrepairmanMapper {
	@Select("SELECT * FROM wh.md_repairman")
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM wh.md_repairman WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO wh.md_repairman (sysid, em_name, em_no, remark) " + " SELECT #{SYSID}, #{EM_NAME}, #{EM_NO}, #{REMARK} "
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM wh.md_repairman WHERE em_no = #{EM_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE wh.md_repairman SET em_name = #{EM_NAME}, em_no = #{EM_NO}, remark = #{REMARK} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
