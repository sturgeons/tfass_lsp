package com.fxtech.ldplatform.jr.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface JRpartMapper {
	@Select("SELECT * FROM wh.v_wh_jiare_store_daily ORDER BY qad_model")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
