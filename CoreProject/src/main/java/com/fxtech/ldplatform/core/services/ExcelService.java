package com.fxtech.ldplatform.core.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.abstracts.excel.BaseExcel;
import com.fxtech.ldplatform.api.inters.excels.IExcelExporter;

/**
 * Excel相关服务
 * 
 * @author Ajaxfan
 */
@Service("excelService")
public class ExcelService extends BaseExcel {
	private @Autowired IExcelExporter excelExporter;

	/**
	 * 导出Excel表格
	 * 
	 * @param meta
	 * @param data
	 * @param out
	 * @throws IOException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void export(String meta, String data, OutputStream out) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> items = mapper.readValue(data, List.class);

		excelExporter.export(meta, items, out);
	}

	/**
	 * 导出Excel表格
	 * 
	 * @param meta
	 * @param data
	 * @param out
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void export(String meta, List datas, OutputStream out) throws IOException {
		excelExporter.export(meta, datas, out);
	}

	@Override
	public void export(List datas, OutputStream out) throws IOException {
		excelExporter.export(datas, out);
	}
}
