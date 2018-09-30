package com.fxtech.ldplatform.fp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface FPstoreMapper {
	@Select("SELECT * FROM wh.v_wh_fengpi_recomment_out WHERE qadno = #{QADNO}  ")
	public List<Map<String, ?>> find(Map<String, ?> params);

}
