package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDsliceboxMapper {
	@Select("SELECT * FROM cut.md_slice_box")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM cut.md_slice_box WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_box (box_no, remark) " 
	        + " SELECT #{BOX_NO}, #{REMARK}  FROM dual" 
	        + " WHERE not exists (SELECT sysid FROM cut.md_slice_box WHERE box_no = #{BOX_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_box SET "
			+ "    box_no = #{BOX_NO}, remark = #{REMARK}"
			+ "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
