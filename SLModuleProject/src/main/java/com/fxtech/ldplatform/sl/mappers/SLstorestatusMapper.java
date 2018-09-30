package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SLstorestatusMapper {
	@Select("SELECT * FROM cut.v_wh_slice_store_status")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
