package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 班次实际
 * @author Administrator
 */
public interface STsactualMapper {
	@Select("select count(ctime) as SACTUAL from v_acc_sactual where line =#{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
