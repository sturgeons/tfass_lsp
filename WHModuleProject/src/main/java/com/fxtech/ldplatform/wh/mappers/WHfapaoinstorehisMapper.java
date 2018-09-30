package com.fxtech.ldplatform.wh.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface WHfapaoinstorehisMapper {
	@Select("select a.* from wh.v_wh_fapao_instore_his a  order by created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
