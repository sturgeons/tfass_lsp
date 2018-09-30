package com.fxtech.ldplatform.md.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;

public interface MDdowntimeMapper {

	@Insert("INSERT INTO md_downtime (sysid, reason, op, begin_time, end_time, line) "
			+ " SELECT sys_guid(), #{reason}, #{op},  "
			+ " f_acc_downtime(#{begin_time}) ,"
			+ " f_acc_downtime(#{end_time}), "
			+ " #{line}" 
			+ " FROM dual")
	public int add(Map<String, ?> attrs);

}
