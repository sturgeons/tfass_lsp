package com.fxtech.ldplatform.zp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ZPinspectorMapper {
	@Select("SELECT * FROM wh.md_inspector ORDER BY inspector_name")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
