package com.fxtech.ldplatform.zp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ZPprintdataMapper {
	@Select("SELECT * FROM TABLE (wh.f_zhuangpei_code(#{qadno}))")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
