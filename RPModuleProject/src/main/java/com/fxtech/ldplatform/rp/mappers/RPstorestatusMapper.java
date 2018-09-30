package com.fxtech.ldplatform.rp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RPstorestatusMapper {
	@Select("SELECT * FROM wh.v_rework_store_status")
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Select("SELECT * FROM wh.v_ok_rework_view")
	public List<Map<String, ?>> query(Map<String, ?> params);

	@Delete("DELETE wh.ok_and_rework WHERE qadno = #{QADNO}")
	public int del(Map<String, ?> attrs);

	@Update("INSERT INTO wh.ok_and_rework (qadno, ok_count, rework_count) VALUES (#{QADNO}, #{OK_COUNT}, #{REWORK_COUNT})")
	public int add(Map<String, ?> attrs);
}
