package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDslicebomMapper {
	@Select("SELECT * FROM cut.v_wh_slice_bom")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM cut.md_slice_bom WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_bom (qadno, cut_no, bom, fabric_no) " + " SELECT #{QADNO}, #{CUT_NO}, #{BOM} , #{FABRIC_NO}"
			+ " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM cut.md_slice_bom WHERE qadno = #{QADNO} AND cut_no = #{CUT_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_bom SET qadno = #{QADNO}, cut_no = #{CUT_NO}, bom = #{BOM}, fabric_no = #{FABRIC_NO}"
			+ "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
