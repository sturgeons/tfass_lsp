package com.fxtech.ldplatform.ls.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface LSoutstorehisMapper {
	@Select("select a.* from wh.v_wh_liangshai_outstore_his a  order by created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
