package com.fxtech.ldplatform.fp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface FPstoredataMapper {
	@Select("SELECT wh.f_fengpi_data_integrity(#{qadno}, #{count},  #{content}) res FROM DUAL")
	public String findInStore(Map<String, ?> attrs);

	@Select("SELECT wh.f_fengpi_calc_unit FROM dual")
	public String findUnitName(Map<String, String> params);

	@Insert("INSERT INTO wh.fengpi_in_record  (record_no, qadno, part_count, batch_no, content, unit_name) "
			+ "SELECT #{packid},  upper(#{qadno}), #{count}, substr(#{packid}, 4, 6), upper(#{content}) , #{unit_name} FROM  dual")
	public int inStore(Map<String, ?> attrs);

	@Select("SELECT a.*, upper(#{content}) content FROM wh.v_wh_fengpi_outstore a "
			+ " WHERE  created < wh.f_date_diff('wh_fengpi_date_diff') and record_no = #{packid}")
	public List<Map<String, ?>> findOutStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh.fengpi_out_record  (record_no, qadno, part_count, batch_no, content, unit_name) "
			+ "SELECT #{RECORD_NO},  upper(#{QADNO}), #{PART_COUNT}, #{BATCH_NO}, upper(#{CONTENT}) , upper(#{UNIT_NAME})"
			+ " FROM  dual")
	public int outStore(Map<String, ?> attrs);
}
