package com.fxtech.ldplatform.rp.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.rp.mappers.RPreportMapper;

@Service("RPreportService")
public class RPreportService {
	private @Autowired RPreportMapper mapper;

	public List<Map<String, ?>> findMaster(Map<String, ?> params) {
		return mapper.findMaster(params);
	}

	public List<Map<String, ?>> findAssyEM(Map<String, ?> params) {
		return mapper.findAssyEM(params);
	}

	public List<Map<String, ?>> findAssyState(Map<String, ?> params) {
		return mapper.findAssyState(params);
	}

	public List<Map<String, ?>> findTeamno(Map<String, ?> params) {
		return mapper.findTeamno(params);
	}

	public List<List<Map<String, ?>>> export(Map<String, ?> params) {
		List<Map<String, ?>> masters = mapper.findMaster(params);
		List<Map<String, ?>> repairs = mapper.findAssyState(params);
		List<Map<String, ?>> teamnos = mapper.findTeamno(params);

		List<Map<String, ?>> assyStateDesc = mapper.findAssyStateDesc(params);
		List<Map<String, ?>> teamnoDesc = mapper.findTeamnoDesc(params);

		List<List<Map<String, ?>>> results = new ArrayList<List<Map<String, ?>>>();
		List<Map<String, ?>> sheet = new ArrayList<Map<String, ?>>();

		for (Map master : masters) {
			Map map = new LinkedHashMap();// 按照属性写入的先后顺序进行导出
			String qadno = (String) master.get("QADNO");// 总成号
			map.put("QADNO", qadno);
			map.put("TOTAL", master.get("TOTAL"));
			map.put("REWORK", master.get("REPAIR_FIRST"));
			map.put("PERCENT", calculate(map));

			// 写入所有的总成检测类型列，防止有数据丢失
			for (Map state : assyStateDesc) {
				map.put(state.get("ASSY_STATE"), "");
			}

			for (Map repair : repairs) {// 总成检测异常类型
				if (qadno.equals(repair.get("QADNO"))) {
					map.put(repair.get("ASSY_STATE"), repair.get("PART_COUNT"));
				}
			}

			// 同上
			for (Map teamno : teamnoDesc) {// 总成检测异常类型
				map.put(teamno.get("TEAMNO"), "");
			}

			for (Map teamno : teamnos) {// 总成检测异常班组
				if (qadno.equals(teamno.get("QADNO"))) {
					map.put(teamno.get("TEAMNO"), teamno.get("PART_COUNT"));
				}
			}
			sheet.add(map);
		}
		results.add(sheet);
		results.add(mapper.findAssyStates());

		return results;
	}

	private String calculate(Map map) {
		String total = String.valueOf(map.get("TOTAL"));
		String rework = String.valueOf(map.get("REWORK"));

		double value = 0;

		try {
			value = Double.valueOf(rework) / Double.valueOf(total);
			value = new BigDecimal(value).setScale(4, BigDecimal.ROUND_UP).doubleValue();
		} catch (Exception e) {
			value = 0;
		}
		return String.valueOf(value);
	}
}
