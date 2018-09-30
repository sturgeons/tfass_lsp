package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDslicecutMapper {
	@Select("SELECT * FROM cut.md_slice_cut ORDER BY cut_no")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM cut.md_slice_cut WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO cut.md_slice_cut (cut_no, prog_no, remark, cut_count, fifo) "
			+ " SELECT upper(#{CUT_NO}),  #{PROG_NO}, #{REMARK}, #{CUT_COUNT}, #{FIFO}  "
			+ " FROM dual WHERE not exists (SELECT sysid FROM cut.md_slice_cut WHERE cut_no = upper(#{CUT_NO}))")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE cut.md_slice_cut SET " + "    cut_no = upper(#{CUT_NO}), remark = #{REMARK}, cut_count = #{CUT_COUNT}, "
			+ "    prog_no = #{PROG_NO}, fifo = #{FIFO}" + "   WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
