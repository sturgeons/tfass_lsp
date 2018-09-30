package com.fxtech.ldplatform.sl.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SLstoredataMapper {
	@Select("SELECT cut.f_slice_instore_verify(upper(#{boxno}), upper(#{content}),  upper(#{qadno})) res FROM DUAL")
	public String findInStore(Map<String, ?> attrs);

	@Insert("INSERT INTO cut.wh_slice_in_record  (record_no, qadno, part_count, batch_no, content,  box_no) "
			+ "SELECT upper(#{packid}),  upper(#{qadno}), #{count}, substr(#{packid}, 4, 6), upper(#{content}) , upper(#{boxno})"
			+ " FROM  dual")
	public int inStore(Map<String, ?> attrs);
	
	@Select("SELECT cut.f_slice_outstore_verify(upper(#{content}),  #{qadno}, #{count}) res FROM DUAL")
	public String findOutStore(Map<String, ?> attrs);

	@Insert("INSERT INTO cut.wh_slice_out_record  (content)  SELECT upper(#{content})  FROM  dual")
	public int outStore(Map<String, ?> attrs);
}
