package com.fxtech.ldplatform.rp.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface RPreportMapper {
	public List<Map<String, ?>> findMaster(Map<String, ?> params);
	public List<Map<String, ?>> findAssyEM(Map<String, ?> params);
	public List<Map<String, ?>> findAssyState(Map<String, ?> params);
	public List<Map<String, ?>> findAssyStateDesc(Map<String, ?> params);
	public List<Map<String, ?>> findTeamno(Map<String, ?> params);
	public List<Map<String, ?>> findTeamnoDesc(Map<String, ?> params);
	
	@Select("SELECT state_code, op, remark FROM wh.md_state ORDER BY state_code")
	public List<Map<String, ?>> findAssyStates();
}
