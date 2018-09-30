package com.fxtech.ldplatform.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fxtech.ldplatform.api.abstracts.reports.BaseReport;
import com.fxtech.report.SimpleReport;

/**
 * 系统通用的简单报表打印功能，开发人员无需再次编码。
 * 
 * @author Ajaxfan
 */
@Configuration
class SimpleReportConfiguration {
	/**
	 * 简单报表打印方法
	 * 
	 * @return
	 */
	@Bean(name = "simpleReport")
	public BaseReport simpleReportPrinter() {
		return new SimpleReport();
	}
}
