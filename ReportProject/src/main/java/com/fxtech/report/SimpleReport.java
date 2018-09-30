package com.fxtech.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.util.List;
import java.util.Map;

import com.fxtech.ldplatform.api.abstracts.reports.BaseReport;
import com.fxtech.ldplatform.api.entities.Header;
import com.fxtech.report.templates.Templates;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author Liutao
 */
public class SimpleReport extends BaseReport {
	private JasperReportBuilder builder;

	/**
	 * 简单报表构建器（简单报表不使用Ireport生成模板，全部由Java代码实现，适用于样式单一的传统表格）
	 * 
	 * @param header
	 * @param datas
	 * @param portrait
	 * @return
	 */
	@Override
	public JasperPrint exportToPrinter(List<Header> headers, List<Map<String, ?>> datas, Map<String, ?> params,
			boolean portrait) {
		try {
			return buildTemplate().buildColumns(headers).buildTitle((String)params.get("TITLE")).buildFooter().buildData(datas)
					.toJasperPrint(portrait);
		} catch (DRException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return 生成报表模板
	 */
	private SimpleReport buildTemplate() {
		builder = report().setTemplate(Templates.reportTemplate);
		return this;
	}

	/**
	 * 构建表格头
	 * 
	 * @param header
	 * @return
	 */
	private SimpleReport buildColumns(List<Header> headers) {
		int i = 0;
		for (Header header : headers) {
			ColumnBuilder<?, ?> cb = col.column(header.getColunmName(), header.getFieldName(), type.stringType());
			if (i == 0) {
				cb.setStyle(Templates.columnStyle.setLeftIndent(10));
			}
			builder.addColumn(cb);
			i++;
		}
		return this;
	}

	private SimpleReport buildTitle(String title) {
		builder.title(Templates.createTitleComponent(title));
		return this;
	}

	private SimpleReport buildFooter() {
		builder.pageFooter(Templates.footerComponent);
		return this;
	}

	private SimpleReport buildData(List<Map<String, ?>> datas) {
		builder.setDataSource(datas);
		return this;
	}

	private JasperPrint toJasperPrint(boolean portrait) throws DRException {
		if (portrait == false) {
			builder.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
		}
		return builder.toJasperPrint();
	}
}