package com.fxtech.ldplatform.md.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface MDstoreMapper {
	public List<Map<String, ?>> find(Map<String, ?> params);

}
