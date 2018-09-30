package com.fxtech.ldplatform.ls.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface LSstoreMapper {
	@Select("SELECT * FROM wh.v_wh_liangshai_recomment_out WHERE qadno = #{QADNO}  ")
	public List<Map<String, ?>> find(Map<String, ?> params);

}
