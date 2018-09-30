package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STvminuteMapper {
	@Select("select * from v_acc_validtime")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
