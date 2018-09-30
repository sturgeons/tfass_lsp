package com.fxtech.ldplatform.zp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ZPinstorehisMapper {
	@Select("SELECT * FROM wh.v_assy_outstore_his ORDER BY created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
