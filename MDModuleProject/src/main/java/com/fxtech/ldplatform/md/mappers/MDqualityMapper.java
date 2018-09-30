package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface MDqualityMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE FROM md_quality WHERE  id = #{id}")
	public int del(Map<String, ?> params);
	
	public int findById(Map<String, ?> params);

	@Insert("INSERT INTO md_quality (id, line, op, qadno, content, check_type, check_method, check_frequency, check_unit, checking_no, tolerance_limit_lower,"
			+ "tolerance_limit_on, measurement_unit, version_no, update_info, updated, data_type, lower_sign, upper_sign, em_no, active) "
			+ " SELECT md_quality_seq.nextval, #{LINE}, #{OP}, #{QADNO}, #{CONTENT}, #{CHECK_TYPE}, #{CHECK_METHOD}, "
			+ "#{CHECK_FREQUENCY}, #{CHECK_UNIT}, #{CHECKING_NO}, #{TOLERANCE_LIMIT_LOWER}, #{TOLERANCE_LIMIT_ON}, #{MEASUREMENT_UNIT}"
			+ ", #{VERSION_NO}, #{UPDATE_INFO}, to_date(#{UPDATED}, 'yyyy-mm-dd'), #{DATA_TYPE}, #{LOWER_SIGN}, #{UPPER_SIGN}, #{EM_NO}, #{ACTIVE} "
			+ " FROM dual")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE md_quality SET line = #{LINE}, op = #{OP} , qadno = #{QADNO} , content = #{CONTENT} , check_type = #{CHECK_TYPE} "
			+ ", check_method = #{CHECK_METHOD} , check_frequency = #{CHECK_FREQUENCY} , check_unit = #{CHECK_UNIT} "
			+ ", checking_no = #{CHECKING_NO} , tolerance_limit_lower = #{TOLERANCE_LIMIT_LOWER} "
			+ ", tolerance_limit_on = #{TOLERANCE_LIMIT_ON} , measurement_unit = #{MEASUREMENT_UNIT} , version_no = #{VERSION_NO},"
			+ " lower_sign = #{LOWER_SIGN}, upper_sign = #{UPPER_SIGN}"
			+ ", update_info = #{UPDATE_INFO} , updated =  to_date(#{UPDATED}, 'yyyy-mm-dd'), data_type = #{DATA_TYPE} "
			+ ", em_no = #{EM_NO}, active = #{ACTIVE}"
			+ "WHERE id = #{ID}")
	public int update(Map<String, ?> attrs);
}
