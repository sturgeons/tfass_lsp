package com.fxtech.ldplatform.api.inters.excels;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface IExcelExporter {
	/**
	 * 导出文件
	 *
	 * @param out
	 *            输出文件流
	 */
	public void export(String meta, List<Map<String, Object>> data, OutputStream out) throws IOException;

	public void export(List<List<Map<String, Object>>> datas, OutputStream out) throws IOException;
}
