package com.fxtech.report.templates;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

/**
 * @author Liutao
 */
public class Templates {
	public static final StyleBuilder rootStyle;
	public static final StyleBuilder boldStyle;
	public static final StyleBuilder italicStyle;
	public static final StyleBuilder boldCenteredStyle;
	public static final StyleBuilder bold18CenteredStyle;
	public static final StyleBuilder columnStyle;
	public static final StyleBuilder columnTitleStyle;

	public static final ReportTemplateBuilder reportTemplate;
	public static final ComponentBuilder<?, ?> footerComponent;

	/**
	 * 第一报表样式，这一个简易报表模板。复杂报表模板需要使用Ireport报表设计工具辅助创建.
	 */
	static {
		rootStyle = stl.style().setPadding(3);
		boldStyle = stl.style(rootStyle).bold();
		italicStyle = stl.style(rootStyle).italic();
		boldCenteredStyle = stl.style(boldStyle).setVerticalAlignment(VerticalAlignment.BOTTOM);
		bold18CenteredStyle = stl.style(boldCenteredStyle).setFontSize(18);
		columnStyle = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setBorder(stl.pen1Point());
		columnTitleStyle = stl.style(columnStyle).setBorder(stl.pen1Point())
				.setHorizontalAlignment(HorizontalAlignment.CENTER).bold().setFontSize(11).setTopPadding(5);

		reportTemplate = template().setLocale(Locale.CHINESE).setColumnStyle(columnStyle)
				.setColumnTitleStyle(columnTitleStyle).setPageFormat(PageType.A4, PageOrientation.PORTRAIT);

		footerComponent = cmp.pageXofY()
				.setStyle(stl.style(boldCenteredStyle).setBottomPadding(15).setTopBorder(stl.pen1Point()));
	}

	/**
	 * Creates custom component which is possible to add to any report band
	 * component
	 */
	public static ComponentBuilder<?, ?> createTitleComponent(String label) {
		return cmp.horizontalList()
				.add(cmp.text(label).setStyle(bold18CenteredStyle).setHorizontalAlignment(HorizontalAlignment.CENTER))
				.newRow()
				.add(cmp.text(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
						.setStyle(stl.style().setFontSize(8).setRightPadding(10))
						.setHorizontalAlignment(HorizontalAlignment.RIGHT))
				.newRow().newRow().add(cmp.verticalGap(5));
	}
}