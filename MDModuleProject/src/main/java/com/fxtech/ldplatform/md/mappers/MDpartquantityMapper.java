package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface MDpartquantityMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM md_part_quantity WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_part_quantity (sysid, line, part_id, quantity, min_quantity, max_supplyment, op) "
			+ " SELECT #{SYSID}, #{LINE}, #{PART_ID}, #{QUANTITY}, #{MIN_QUANTITY}, #{MAX_SUPPLYMENT}, #{OP} "
			+ " FROM dual "
			+ " WHERE not exists (SELECT sysid FROM md_part_quantity WHERE line = #{LINE} AND part_id = #{PART_ID})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_part_quantity SET line = #{LINE}, part_id = #{PART_ID}, "
			+ "quantity=#{QUANTITY}, max_supplyment = #{MAX_SUPPLYMENT}, min_quantity = #{MIN_QUANTITY} ,"
			+ "op=#{OP}"
			+ "WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);

	@Insert("INSERT INTO log_part_quantity SELECT sys_guid(), sysid, line, #{LINE}, part_id, #{PART_ID},"
			+ " quantity, #{QUANTITY}, min_quantity, #{MIN_QUANTITY}, max_supplyment, #{MAX_SUPPLYMENT}, "
			+ " #{REASON_ID}, sysdate, #{EM_ID} FROM md_part_quantity WHERE sysid = #{SYSID}")
	public void logUpdate(Map<String, ?> attrs);
}
