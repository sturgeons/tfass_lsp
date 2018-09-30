package com.fxtech.ldplatform.st.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("STtimeService")
public class STtimeService {
	private DateFormat df = new SimpleDateFormat("MMM-dd HH:mm", Locale.ENGLISH);

	public List<Map<String, ?>> find(Map<String, ?> params) {
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", df.format(java.util.GregorianCalendar.getInstance().getTime()));
		list.add(map);

		return list;
	}
}
