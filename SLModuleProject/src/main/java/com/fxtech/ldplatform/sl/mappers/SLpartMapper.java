package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface SLpartMapper {
	@Select("SELECT * FROM cut.v_wh_slice_qad")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
