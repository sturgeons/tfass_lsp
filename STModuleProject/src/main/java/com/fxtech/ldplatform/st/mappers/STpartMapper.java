package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface STpartMapper {
	@Select("SELECT * FROM v_acc_store_daily ORDER BY qad_type, qad_no")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
