package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface MDbomdataMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM md_partdata WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_partdata (sysid, line, op, qad_id, part_id, bom, active, consume_hour) "
			+ " SELECT #{SYSID}, #{LINE}, #{OP}, #{QAD_ID}, #{PART_ID}, "
			+ "#{BOM}, #{ACTIVE}, #{CONSUME_HOUR} " + " FROM dual")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_partdata SET line = #{LINE}, op = #{OP}, qad_id=#{QAD_ID},"
			+ "part_id = #{PART_ID}, bom = #{BOM},"
			+ "active=#{ACTIVE},"
			+ "consume_hour = #{CONSUME_HOUR} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
