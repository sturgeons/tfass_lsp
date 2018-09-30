package com.fxtech.ldplatform.wh.mappers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WHfapaofifoMapper {
	@Select("SELECT * FROM wh.v_fapao_extra ORDER BY qad_model, qadno")
	public List<LinkedHashMap<String, ?>> find();

	@Delete("DELETE FROM wh.md_fapao_extra WHERE qadno = #{QADNO}")
	public int del(Map<String, ?> params);
	
	@Update("INSERT INTO wh.md_fapao_extra (qadno, fifo, min_num, max_num) "
			+ " VALUES (#{QADNO}, #{FIFO}, #{MIN_NUM}, #{MAX_NUM})")
	public int add(Map<String, ?> attrs);
}
