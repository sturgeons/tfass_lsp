package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDslicefabricMapper {
	@Select("SELECT * FROM cut.md_slice_fabric ORDER BY fabric_no")
	public List<Map<String, ?>> find(Map<String, ?> params);
	
	public List<Map<String, ?>> findByQadno(Map<String, ?> params);

	@Delete("DELETE FROM cut.md_slice_fabric WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_fabric (fabric_no, remark) " 
	        + " SELECT upper(#{FABRIC_NO}), #{REMARK}  FROM dual" 
	        + " WHERE not exists (SELECT sysid FROM cut.md_slice_fabric WHERE fabric_no = #{FABRIC_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_fabric SET "
			+ "    fabric_no = upper(#{FABRIC_NO}), remark = #{REMARK}"
			+ "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
