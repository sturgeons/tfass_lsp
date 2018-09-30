package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STusedpercentMapper {
	@Select("select * from MD_USED_PERCENT")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
