package com.fxtech.ldplatform.rp.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface RPstoredataMapper {
	@Select("SELECT wh.f_rework_data_integrity(#{status}, #{content}, #{confirm}) res FROM DUAL")
	public String findInStore(Map<String, ?> attrs);

	@Select("SELECT wh.f_rework_part_status(#{content}) status FROM DUAL")
	public String findStatus(Map<String, ?> params);

	@Insert("INSERT INTO wh.rework_out_record  (content, em_no, status, confirm) "
			+ "SELECT upper(#{content}), #{emp}, state_code, #{confirm} FROM  wh.md_state WHERE state_code = #{status}")
	public int inStore(Map<String, ?> attrs);
}
