package com.fxtech.ldplatform.zp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDteamnoMapper {
	@Select("SELECT * FROM wh.md_teamno")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM wh.md_teamno WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO wh.md_teamno (team_no, remark) " + " SELECT #{TEAM_NO}, #{REMARK} " + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM wh.md_teamno WHERE team_no = #{TEAM_NO})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE wh.md_teamno SET team_no = #{TEAM_NO}, remark = #{REMARK} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
