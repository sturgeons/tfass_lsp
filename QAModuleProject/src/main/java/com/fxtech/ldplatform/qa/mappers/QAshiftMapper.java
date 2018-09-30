package com.fxtech.ldplatform.qa.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface QAshiftMapper {
	@Select("SELECT t.shift_name, DECODE(a.shift_name, '', 0, 1) selected "
			+ " FROM md_shift t LEFT JOIN t_acc_shift a ON t.shift_name = a.shift_name"
			+ " ORDER BY shift_name")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
