package com.fxtech.ldplatform.fp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface FPstorestatusMapper {
	@Select("SELECT * FROM wh.v_wh_fengpstatus_with_timediff ORDER BY unit_name")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
