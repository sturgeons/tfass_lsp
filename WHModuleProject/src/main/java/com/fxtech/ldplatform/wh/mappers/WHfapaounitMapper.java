package com.fxtech.ldplatform.wh.mappers;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface WHfapaounitMapper {
	@Select("SELECT * FROM wh.v_wh_units")
	public List<LinkedHashMap<String, ?>> find();
}
