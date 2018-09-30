package com.fxtech.ldplatform.api.abstracts.reports;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.fxtech.ldplatform.api.entities.Header;
import com.fxtech.ldplatform.api.inters.reports.IReport;

/**
 * 报表工具的抽象接口定义
 * 
 * @author Ajaxfan
 */
public abstract class BaseReport implements IReport {

	/**
	 * 通过定义好的报表模板打印
	 * 
	 * @param header
	 * @param datas
	 * @param portrait
	 * @return
	 */
	@Override
	public Object exportToPrinter(List<Header> header, List<Map<String, ?>> datas, Map<String, ?> params,
			boolean portrait) {
		throw new UnsupportedOperationException("Un supported operation. the method is not implemented.");
	}

	/**
	 * 通过设计器创建的模板打印报表
	 * 
	 * @param datas
	 * @param params
	 * @param jasper
	 * @return
	 */
	@Override
	public Object exportToPrinter(List<Map<String, Object>> datas, Map<String, Object> params, InputStream jasper) {
		throw new UnsupportedOperationException("Un supported operation. the method is not implemented.");
	}
}
