package com.fxtech.ldplatform.md.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MDpartdataMapper {
	@Insert("insert into tg_record  (id, partno, partnum, fullcode, line, op) "
			+ "select upper(#{id}),  upper(#{partno}), #{count}, upper(#{full}), #{line}, #{op} "
			+ "from dual where not exists (" + " select id from tg_record where id = upper(#{id}))")
	public int add(Map<String, ?> attrs);

	@Update("update md_part_quantity set quantity = quantity + #{count} where exists ("
			+ " select sysid from md_part where sysid = part_id and partno = upper(#{partno}))" + " and line = #{line} and op = #{op}")
	public int update(Map<String, ?> attrs);

	@Select("select f_valid_supplyment(#{partno}, #{line}, #{op}) is_valid from dual ")
	public int check(Map<String, ?> params);
}
