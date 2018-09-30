package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 小时计划
 * @author Administrator
 */
public interface SThplanMapper {
	@Select("select round(nvl(sum(plan_count), 0) / 24) as HPLAN from v_acc_plan where line = #{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
