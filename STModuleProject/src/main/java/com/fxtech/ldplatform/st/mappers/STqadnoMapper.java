package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface STqadnoMapper {
	@Select("SELECT * FROM v_wh_qadno")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
