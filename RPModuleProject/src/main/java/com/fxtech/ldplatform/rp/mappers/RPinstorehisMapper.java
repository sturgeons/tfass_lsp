package com.fxtech.ldplatform.rp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface RPinstorehisMapper {
	@Select("select a.* from wh.v_rework_outstore_his a  order by created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
