package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STinstorehisMapper {
	@Select("select a.*, b.cust_partno from v_wh_instore_his a inner join v_acc_part_table b on a.qadno = b.qadno order by created")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
