package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STemlineMapper {
	@Select("SELECT line FROM v_quality_line WHERE not exists (" + "  SELECT em_id FROM re_quality_employee"
			+ " WHERE em_line = line AND em_id = #{EM_ID}) GROUP BY line")
	public List<Map<String, ?>> findUnBindByUser(Map<String, ?> params);

	@Select("SELECT a.line, #{EM_ID} em_id FROM v_quality_line a WHERE exists (" + "  SELECT em_id FROM re_quality_employee"
			+ " WHERE em_line = line AND em_id = #{EM_ID}) GROUP BY line")
	public List<Map<String, ?>> findBindByUser(Map<String, ?> params);
}
