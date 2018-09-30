package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STshiftMapper {
	@Select("select * from v_acc_shift")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
