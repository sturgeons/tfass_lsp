package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STpartnoMapper {
	@Select("SELECT a.qadno value, a.partno FROM v_acc_qadno_comb a WHERE a.line = #{LINE} ORDER BY a.qadno, a.partno")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
