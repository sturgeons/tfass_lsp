package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface WHassytoreworkMapper {
	@Select("SELECT * FROM wh.assy_to_rework WHERE content = #{CONTENT}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
