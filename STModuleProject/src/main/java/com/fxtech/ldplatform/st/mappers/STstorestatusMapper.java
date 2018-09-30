package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STstorestatusMapper {
	@Select("SELECT unit_name FROM wh_store_status")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
