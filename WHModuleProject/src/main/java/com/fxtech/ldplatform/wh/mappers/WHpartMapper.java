package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface WHpartMapper {
	@Select("SELECT * FROM wh.v_wh_fapao_store_daily ORDER BY qad_type, qad_no")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
