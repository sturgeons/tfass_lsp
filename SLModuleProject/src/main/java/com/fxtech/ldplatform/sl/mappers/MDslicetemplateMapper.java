package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDslicetemplateMapper {
	@Select("SELECT * FROM cut.md_slice_template")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM cut.md_slice_template WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_template (qadno, fabric_no, t_ratio, t_piles) " + " SELECT #{QADNO},  #{FABRIC_NO}, #{T_RATIO}, #{T_PILES}"
			+ " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM cut.md_slice_template WHERE qadno = #{QADNO} AND fabric_no = #{FABRIC_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_template SET qadno = #{QADNO}, fabric_no = #{FABRIC_NO}, t_ratio = #{T_RATIO}, t_piles = #{T_PILES}"
			+ "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
