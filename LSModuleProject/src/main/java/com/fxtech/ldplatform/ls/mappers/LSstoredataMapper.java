package com.fxtech.ldplatform.ls.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LSstoredataMapper {
	@Select("SELECT upper(#{qadno}) qadno, #{count} part_count, substr(#{packid}, 4, 6) batch_no,  #{packid} packid, "
			+ "upper(#{content}) content , upper(wh.f_jiare_calc_unit(upper(#{qadno}), substr(#{packid}, 4, 6), #{count})) unit_name"
			+ " FROM wh.md_part_bom WHERE NOT EXISTS ("
			+ " SELECT sysid FROM wh.wh_liangshai_in_record WHERE content = #{content}) ")
	public List<Map<String, ?>> findInStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh.wh_liangshai_in_record  (record_no, qadno, part_count, batch_no, content, unit_name) "
			+ "SELECT #{PACKID},  upper(#{QADNO}), #{PART_COUNT}, #{BATCH_NO}, upper(#{CONTENT}) , upper(#{UNIT_NAME})"
			+ " FROM  dual")
	public int inStore(Map<String, ?> attrs);
	
	@Select("SELECT a.*, upper(#{content}) content FROM wh.v_wh_liangshai_outstore a WHERE  created < wh.f_date_diff('wh_liangshai_date_diff') and record_no = #{packid}")
	public List<Map<String, ?>> findOutStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh.wh_liangshai_out_record  (record_no, qadno, part_count, batch_no, content, unit_name) "
			+ "SELECT #{RECORD_NO},  upper(#{QADNO}), #{PART_COUNT}, #{BATCH_NO}, upper(#{CONTENT}) , upper(#{UNIT_NAME})"
			+ " FROM  dual")
	public int outStore(Map<String, ?> attrs);
}
