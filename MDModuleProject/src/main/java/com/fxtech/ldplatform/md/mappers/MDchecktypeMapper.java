package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDchecktypeMapper {
	@Select("SELECT * FROM md_checktype")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_checktype WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_checktype (sysid, type_name, remark) " + " SELECT MD_CHECKTYPE_SEQ.nextval,  #{TYPE_NAME}, #{REMARK} " + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM md_checktype WHERE type_name = #{TYPE_NAME})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_checktype SET type_name = #{TYPE_NAME}, remark = #{REMARK} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
