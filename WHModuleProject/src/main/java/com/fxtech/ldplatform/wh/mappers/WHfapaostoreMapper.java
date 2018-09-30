package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface WHfapaostoreMapper {
	@Select("SELECT * FROM wh.v_wh_fapao_recomment_out WHERE qadno = #{QADNO}  ")
	public List<Map<String, ?>> find(Map<String, ?> params);

}
