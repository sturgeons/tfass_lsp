package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDmeasurementunitMapper {
	@Select("SELECT * FROM md_measurement_unit")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM md_measurement_unit WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO md_measurement_unit (sysid, unit_name, remark) " + " SELECT MD_MEASUREMENT_UNIT_SEQ.nextval,  #{UNIT_NAME}, #{REMARK} " + " FROM dual"
			+ " WHERE not exists (SELECT sysid FROM md_measurement_unit WHERE unit_name = #{UNIT_NAME})")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_measurement_unit SET unit_name = #{UNIT_NAME}, remark = #{REMARK} WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
