package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MDstoredataMapper {
	@Select("SELECT upper(#{qadno}) qadno, #{count} part_count, batch_no,  packid, "
			+ "upper(#{content}) content , upper(f_calc_unit(upper(#{qadno}), batch_no, #{count})) unit_name"
			+ " FROM v_acc_pack_data where not exists ("
			+ " SELECT sysid FROM wh_store_status WHERE record_no = upper(#{packid})) AND packid = #{packid}")
	public List<Map<String, ?>> findInStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh_in_record  (record_no, qadno, part_count, batch_no, content, unit_name) "
			+ "SELECT #{PACKID},  upper(#{QADNO}), #{PART_COUNT}, #{BATCH_NO}, upper(#{CONTENT}) , upper(#{UNIT_NAME})"
			+ " FROM  dual")
	public int inStore(Map<String, ?> attrs);
	
	@Select("SELECT a.*, upper(#{content}) content FROM v_acc_valid_outstore a WHERE record_no = #{packid}")
	public List<Map<String, ?>> findOutStore(Map<String, ?> attrs);

	@Insert("INSERT INTO wh_out_record  (record_no, qadno, part_count, batch_no, content, unit_name) "
			+ "SELECT #{RECORD_NO},  upper(#{QADNO}), #{PART_COUNT}, #{BATCH_NO}, upper(#{CONTENT}) , upper(#{UNIT_NAME})"
			+ " FROM  dual")
	public int outStore(Map<String, ?> attrs);
}
