package com.fxtech.ldplatform.fp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface FPinstorehisMapper {
	@Select("SELECT * FROM wh.v_wh_fengpi_instore_his ORDER BY created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
