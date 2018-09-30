package com.fxtech.ldplatform.fp.mappers;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface FPunitMapper {
	@Select("SELECT * FROM wh.v_wh_fengpi_units")
	public List<LinkedHashMap<String, ?>> find();
}
