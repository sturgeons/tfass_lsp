package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface WHfapaostorestatusMapper {
	@Select("SELECT * FROM wh.v_wh_fapaostatus_with_timediff ORDER BY unit_name")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
