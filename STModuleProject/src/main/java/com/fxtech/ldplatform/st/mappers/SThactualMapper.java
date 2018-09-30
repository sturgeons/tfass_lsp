package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 小时实际
 * @author Administrator
 */
public interface SThactualMapper {
	@Select("select * from v_acc_hactual where line =#{LINE}")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
