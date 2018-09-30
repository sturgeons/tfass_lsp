package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STfapaostorestatusMapper {
	@Select("SELECT * FROM v_wh_status_with_timediff ORDER BY unit_name")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
