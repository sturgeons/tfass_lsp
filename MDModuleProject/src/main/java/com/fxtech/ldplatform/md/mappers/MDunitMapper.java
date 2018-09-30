package com.fxtech.ldplatform.md.mappers;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MDunitMapper {
	@Select("SELECT * FROM v_units")
	public List<LinkedHashMap<String, ?>> find();
}
