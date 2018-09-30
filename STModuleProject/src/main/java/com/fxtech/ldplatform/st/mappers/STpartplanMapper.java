package com.fxtech.ldplatform.st.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 零件计划
 * @author Administrator
 */
public interface STpartplanMapper {
	@Select("select plan_count from md_insplan "
			+ " where partno in( select a.value from V_ACC_PARTTYPE a inner join ("
			+ " select max(partno) partno, max(ctime) from V_ACC_TGDATA t"
			+ " where line = #{LINE} and op = #{OP}"
			+ ") b on a.partno = b.partno)")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
