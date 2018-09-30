package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDstateMapper {
	@Select("SELECT * FROM wh.md_state")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM wh.md_state WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO wh.md_state (sysid, state_type, op, remark, state_code) " + " SELECT #{SYSID},  #{STATE_TYPE}, #{OP}, #{REMARK}, #{STATE_CODE}"
			+ " FROM dual" + " WHERE not exists (SELECT sysid FROM wh.md_state WHERE state_code = #{STATE_CODE})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE wh.md_state SET state_type = #{STATE_TYPE}, op = #{OP}, remark = #{REMARK} , state_code = #{STATE_CODE}  WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
