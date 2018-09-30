package com.fxtech.ldplatform.rp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface RPrepairmanMapper {
	@Select("SELECT em_no FROM wh.md_repairman WHERE em_no = #{em_no}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
