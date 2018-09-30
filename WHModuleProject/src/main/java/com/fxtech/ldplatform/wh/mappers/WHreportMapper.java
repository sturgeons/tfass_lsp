package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface WHreportMapper {
	@Select("SELECT * FROM wh.v_wh_store_simple_report")
	public List<Map<String, ?>> findSimple(Map<String, ?> params);

	@Select("SELECT * FROM wh.v_wh_store_report")
	public List<Map<String, ?>> findFull(Map<String, ?> params);
}
