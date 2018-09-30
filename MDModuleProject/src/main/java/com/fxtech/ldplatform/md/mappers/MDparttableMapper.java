package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDparttableMapper {
	@Select("SELECT * FROM md_valid_part")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_valid_part WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_valid_part (qadno, fifo, volume, min_store, max_store) " + " SELECT  #{QADNO}, #{FIFO},"
			+ " #{VOLUME}, #{MIN_STORE}, #{MAX_STORE}" + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM md_valid_part WHERE qadno = #{QADNO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_valid_part SET qadno = #{QADNO}, fifo = #{FIFO}, volume = #{VOLUME},"
			+ " min_store = #{MIN_STORE}, max_store = #{MAX_STORE} " + "WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
