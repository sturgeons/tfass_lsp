package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDsliceqadMapper {
	@Select("SELECT * FROM cut.md_slice_qad")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM cut.md_slice_qad WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_qad (qadno, remark, model, in_out, line, shelf) " 
	        + " SELECT #{QADNO}, #{REMARK}, #{MODEL}, #{IN_OUT}, #{LINE}, #{SHELF} "
			+ " FROM dual" 
	        + " WHERE not exists (SELECT sysid FROM cut.md_slice_qad WHERE qadno = #{QADNO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_qad SET "
			+ "    qadno = #{QADNO}, remark = #{REMARK}, model = #{MODEL},"
			+ "    in_out = #{IN_OUT}, line = #{LINE}, shelf = #{SHELF}"
			+ "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
