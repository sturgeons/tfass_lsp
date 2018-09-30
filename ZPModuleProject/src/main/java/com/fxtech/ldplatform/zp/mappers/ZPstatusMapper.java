package com.fxtech.ldplatform.zp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ZPstatusMapper {
	@Select("SELECT * FROM wh.v_assy_status")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
