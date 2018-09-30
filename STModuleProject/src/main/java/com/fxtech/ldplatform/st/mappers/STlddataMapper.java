package com.fxtech.ldplatform.st.mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface STlddataMapper {
	@Select("select * from v_ld_data")
	public List<Map<String, ?>> find(Map<String, ?> params);

	@Select("INSERT INTO md_print_data SELECT #{pageNo}, #{datas}, #{print_date} FROM DUAL")
	public List<Map<String, ?>> save(@Param("pageNo") String pageNo, @Param("datas") String datas,
			@Param("print_date") Date print_date);

	@Select("SELECT f_acc_print_data_seq() FROM DUAL")
	public String nextPageNo();
}
