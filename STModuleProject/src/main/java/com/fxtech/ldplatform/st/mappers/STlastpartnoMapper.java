package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STlastpartnoMapper {
	@Select("select * from TABLE(f_acc_lastpart) where line = #{LINE} and op = #{OP}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
