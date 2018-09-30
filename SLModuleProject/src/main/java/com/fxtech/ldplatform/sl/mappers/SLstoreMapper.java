package com.fxtech.ldplatform.sl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface SLstoreMapper {
	@Select("SELECT * FROM table (cut.f_slice_store(#{QADNO}))")
	public List<Map<String, ?>> find(Map<String, ?> params);
}
