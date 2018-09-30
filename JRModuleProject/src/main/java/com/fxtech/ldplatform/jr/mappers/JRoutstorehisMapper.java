package com.fxtech.ldplatform.jr.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface JRoutstorehisMapper {
	@Select("select a.* from wh.v_wh_jiare_outstore_his a  order by created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
