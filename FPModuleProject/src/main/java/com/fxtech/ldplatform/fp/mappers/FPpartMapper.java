package com.fxtech.ldplatform.fp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface FPpartMapper {
	@Select("SELECT * FROM wh.v_wh_fengpi_store_daily ORDER BY qad_type")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
