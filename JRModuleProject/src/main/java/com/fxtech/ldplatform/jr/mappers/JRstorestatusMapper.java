package com.fxtech.ldplatform.jr.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface JRstorestatusMapper {
	@Select("SELECT * FROM wh.v_wh_jiarestatus_with_timediff WHERE qadno = #{QADNO} ORDER BY diff  DESC")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
