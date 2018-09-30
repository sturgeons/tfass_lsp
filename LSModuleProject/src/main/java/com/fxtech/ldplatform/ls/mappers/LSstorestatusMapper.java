package com.fxtech.ldplatform.ls.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface LSstorestatusMapper {
	@Select("SELECT * FROM wh.v_wh_lshaistatus_with_timediff ORDER BY unit_name")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
