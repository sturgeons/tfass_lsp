package com.fxtech.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fxtech.ldplatform.api.inters.excels.IExcelExporter;

/**
 * 文件的导出操作
 */
public class ExcelExporterImpl implements IExcelExporter {
	private Logger log = Logger.getLogger(ExcelExporterImpl.class);

	/**
	 * 导出电子表格
	 */
	@Override
	public void export(String meta, List<Map<String, Object>> data, OutputStream out) throws IOException {
		// 加载电子表格模板
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建电子表格
		makeSheet(workbook.createSheet(), meta, data);

		// 写出电子表格到客户端
		workbook.write(out);
	}

	/**
	 * 制作电子表格
	 * 
	 * @param sheet
	 * @param list
	 */
	private void makeSheet(HSSFSheet sheet, String meta, List<Map<String, Object>> data) {
		log.debug("Render Excel Header");
		renderHeader(sheet, meta);

		log.debug("Render Excel Body");
		int rowIndex = 1;// 数据行行索引，第一行为表格头，所以数据从第二行开始
		for (Map<String, Object> map : data) {
			int cellIndex = 0;// 列索引，从第一列开始复制
			HSSFRow row = sheet.createRow(rowIndex);// 创建数据行

			// 按顺序填充表格信息
			for (String key : map.keySet()) {
				row.createCell(cellIndex++).setCellValue(map.get(key).toString().trim());
			}
			rowIndex++;
		}
	}

	/**
	 * 制作表头
	 * 
	 * @param sheet
	 * @param meta
	 */
	private String[] renderHeader(HSSFSheet sheet, String meta) {
		HSSFRow row = sheet.createRow(0);// 创建数据行
		int cellIndex = 0;// 列索引，从第一列开始复制

		String[] headers = meta.replaceAll("[\\[\\]\"]", "").split(",");
		
		for (String header : headers) {
			row.createCell(cellIndex++).setCellValue(header.trim());
		}
		return headers;
	}
	
	private void fillSheet(HSSFSheet sheet, String meta, List<Map<String, Object>> data){
		log.debug("Render Excel Header");
		String[] headers = renderHeader(sheet, meta);

		log.debug("Render Excel Body");
		int rowIndex = 1;// 数据行行索引，第一行为表格头，所以数据从第二行开始
		for (Map<String, Object> map : data) {
			int cellIndex = 0;// 列索引，从第一列开始复制
			HSSFRow row = sheet.createRow(rowIndex);// 创建数据行

			// 按顺序填充表格信息
			for (String key : headers) {
				row.createCell(cellIndex++).setCellValue(map.containsKey(key = key.trim()) ? map.get(key).toString().trim() : "");
			}
			rowIndex++;
		}
	}

	@Override
	public void export(List<List<Map<String, Object>>> datas, OutputStream out) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();

		for (List<Map<String, Object>> sheet : datas) {
			Map map = new HashMap();
			if (datas.size() > 0) {
				for (Map innerMap : sheet) {
					if (innerMap.keySet().size() > map.keySet().size()) {
						map = innerMap;
					}
				}
			}
			fillSheet(workbook.createSheet(), Arrays.toString(map.keySet().toArray()), sheet);
		}
		workbook.write(out);
	}
}