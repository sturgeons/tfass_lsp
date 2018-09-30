package com.fxtech.ldplatform.rp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface RPstatusMapper {
	@Select("SELECT * FROM wh.v_rework_status")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
