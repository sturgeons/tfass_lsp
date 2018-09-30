package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SLbalanceMapper {
	@Select("SELECT * FROM cut.v_wh_slice_balance")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
