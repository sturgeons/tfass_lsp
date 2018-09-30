package com.fxtech.ldplatform.zp.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ZPstoredataMapper {
	@Select("SELECT wh.f_assy_data_integrity(#{status}, #{content}, #{teamno}) res FROM DUAL")
	public String findInStore(Map<String, ?> attrs);

	@Select("SELECT wh.f_assy_part_status(#{content}) status FROM DUAL")
	public String findStatus(Map<String, ?> params);

	@Insert("INSERT INTO wh.assy_out_record  (content, em_no, status, teamno) "
			+ "SELECT upper(#{content}), #{emp}, state_code, #{teamno} FROM  wh.md_state WHERE state_code = #{status}")
	public int inStore(Map<String, ?> attrs);
}
