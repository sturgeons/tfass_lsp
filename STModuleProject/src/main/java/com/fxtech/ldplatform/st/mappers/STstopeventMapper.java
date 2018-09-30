package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STstopeventMapper {
	@Select("SELECT * from ST_STOPEVENT")
	public List<Map<String, ?>> find();
}
