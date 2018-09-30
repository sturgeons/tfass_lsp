package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface QApartMapper {
	@Select("SELECT qadno FROM v_qa_part_list WHERE line = #{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
