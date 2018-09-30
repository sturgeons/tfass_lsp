package com.fxtech.ldplatform.api.inters.reports;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.fxtech.ldplatform.api.entities.Header;

public interface IReport {
	/**
	 * 打印报表
	 * 
	 * @param title
	 *            表格头信息
	 * @param header
	 *            表格头信息
	 * @param datas
	 *            表格数据
	 * @param portrait
	 *            纸张的打印方向
	 * @return
	 */
	public Object exportToPrinter(List<Header> header, List<Map<String, ?>> datas, Map<String, ?> params,
			boolean portrait);

	/**
	 * 通过报表模板打印报表对象
	 * 
	 * @param datas
	 *            要打印的数据集合
	 * @param params
	 *            报表参数
	 * @param jasper
	 *            报表模板
	 * @return
	 */
	public Object exportToPrinter(List<Map<String, Object>> datas, Map<String, Object> params, InputStream jasper);
}
