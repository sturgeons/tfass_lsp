package com.fxtech.ldplatform.jr.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface JRstoredataMapper {
	@Select("SELECT upper(#{qadno}) qadno, #{count} part_count, substr(#{packid}, 4, 6) batch_no,  #{packid} packid, "
			+ "upper(#{content}) content "
			+ " FROM wh.md_part_bom WHERE NOT EXISTS ("
			+ " SELECT sysid FROM wh.wh_jiare_in_record WHERE content = #{content}) ")
	public List<Map<String, ?>> findInStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh.wh_jiare_in_record  (record_no, qadno, part_count, batch_no, content) "
			+ "SELECT #{PACKID},  upper(#{QADNO}), #{PART_COUNT}, #{BATCH_NO}, upper(#{CONTENT})"
			+ " FROM  dual")
	public int inStore(Map<String, ?> attrs);
	
	@Select("SELECT a.*, upper(#{content}) content FROM wh.v_wh_jiare_outstore a WHERE  created < wh.f_date_diff('wh_jiare_date_diff') and record_no = #{packid}")
	public List<Map<String, ?>> findOutStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh.wh_jiare_out_record  (record_no, qadno, part_count, batch_no, content) "
			+ "SELECT #{RECORD_NO},  upper(#{QADNO}),  #{PART_COUNT},  #{BATCH_NO},  upper(#{CONTENT}) "
			+ " FROM  dual")
	public int outStore(Map<String, ?> attrs);
}
