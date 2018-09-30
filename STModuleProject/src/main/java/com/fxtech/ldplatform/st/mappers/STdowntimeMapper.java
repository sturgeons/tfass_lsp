package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface STdowntimeMapper {
	@Select("select * from v_acc_downtime where line = #{LINE} and op = #{OP} order by end_time desc, begin_time desc")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
