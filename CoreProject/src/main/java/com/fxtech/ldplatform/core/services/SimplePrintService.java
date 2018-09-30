package com.fxtech.ldplatform.core.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.abstracts.reports.BaseReport;
import com.fxtech.ldplatform.api.abstracts.services.BasePrintService;
import com.fxtech.ldplatform.api.entities.Header;

@Service("SimplePrintService")
public class SimplePrintService extends BasePrintService {
	private @Autowired BaseReport simpleReport;

	@SuppressWarnings("unchecked")
	@Override
	public Object print(Map<String, ?> args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<Header> headers = mapper.readValue((String) args.get("meta"), List.class);
		List<Map<String, ?>> datas = mapper.readValue((String) args.get("data"), List.class);
		Map<String, ?> params = mapper.readValue((String) args.get("param"), Map.class);

		return simpleReport.exportToPrinter(headers, datas, params, true);
	}
}
