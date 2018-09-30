package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Administrator
 */
public interface WHfapaotofengpiMapper {
	@Select("SELECT * FROM wh.v_fengpi_store_view ORDER by qadno")
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Delete("DELETE wh.fapao_to_fengpi WHERE qadno = #{QADNO}")
	public int del(Map<String, ?> attrs);

	@Update("INSERT INTO wh.fapao_to_fengpi (qadno, amount) VALUES (#{QADNO}, #{AMOUNT})")
	public int add(Map<String, ?> attrs);
}
