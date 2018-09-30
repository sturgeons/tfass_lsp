package com.fxtech.ldplatform.st.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.st.mappers.STchartMapper;

@Service("STchartService")
public class STchartService {
	private @Autowired STchartMapper stchartMapper;
	
	Logger log = Logger.getLogger(STchartService.class);


	public List<Object> find(Map<String, ?> params) {
		log.info("STchartService Invoke.");
		
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
		Map<String, Object> map = new HashMap<String, Object>();
		Set set = new HashSet();

		Object name = null;
		for (Map<String, ?> entity : stchartMapper.find(params)) {
			if (!entity.get("NAME").equals(name)) {
				list.add(map = new HashMap<String, Object>());
			}
			map.put("name", name = entity.get("NAME"));
			map.put((String) entity.get("PARTNO"), entity.get("TOTAL"));
			
			set.add(entity.get("PARTNO"));
		}
		Map res = new HashMap();
		res.put("keys", set);
		res.put("datas", list);
		

		log.info(res.keySet().size());

		return Arrays.asList(new Object[] { res });
	}
}
