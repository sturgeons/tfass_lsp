package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 班次计划
 * @author Administrator
 */
public interface STsplanMapper {
	@Select("select round(nvl(sum(plan_count), 0) / 8) as SPLAN from v_acc_plan where line = #{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
