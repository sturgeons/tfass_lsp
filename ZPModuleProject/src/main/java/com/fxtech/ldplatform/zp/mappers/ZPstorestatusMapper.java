package com.fxtech.ldplatform.zp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ZPstorestatusMapper {
	@Select("SELECT * FROM wh.v_assy_store_status")
	public List<Map<String, ?>> find(Map<String, ?> params);
	
	@Select("SELECT * FROM wh.assy_store_status ORDER BY qad_type, qadno")
	public List<Map<String, ?>> query(Map<String, ?> params);

	@Update("UPDATE wh.assy_store_status SET status_ok = #{STATUS_OK}, repair_wait = #{REPAIR_WAIT} WHERE qadno = #{QADNO}")
	public int update(Map<String, ?> attrs);
}
