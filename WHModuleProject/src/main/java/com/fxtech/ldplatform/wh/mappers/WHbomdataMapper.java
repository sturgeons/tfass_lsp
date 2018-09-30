package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WHbomdataMapper {
	@Select("SELECT * FROM wh.md_part_bom")
	public List<Map<String, ?>> find();

	@Delete("DELETE FROM wh.md_part_bom WHERE sysid = #{SYSID}")
	public int del(Map<String, ?> params);

	@Insert("INSERT INTO wh.md_part_bom (skeleton, fapao_qadno, fengpi_qadno, fengpi_model, fengpi_desc, zhuangpei_qadno, qad_model, qad_desc) "
			+ " SELECT #{SKELETON}, #{FAPAO_QADNO}, #{FENGPI_QADNO}, #{FENGPI_MODEL}, #{FENGPI_DESC}, #{ZHUANGPEI_QADNO}"
			+ ", #{QAD_MODEL}, #{QAD_DESC} " + " FROM dual")
	public int add(Map<String, ?> attrs);

	@Update("UPDATE wh.md_part_bom SET skeleton = #{SKELETON}, fapao_qadno = #{FAPAO_QADNO}, "
			+ " fengpi_qadno = #{FENGPI_QADNO}, fengpi_model = #{FENGPI_MODEL}, fengpi_desc = #{FENGPI_DESC},"
			+ " zhuangpei_qadno = #{ZHUANGPEI_QADNO}, qad_model = #{QAD_MODEL}, qad_desc = #{QAD_DESC}"
			+ "WHERE sysid = #{SYSID}")
	public int update(Map<String, ?> attrs);
}
