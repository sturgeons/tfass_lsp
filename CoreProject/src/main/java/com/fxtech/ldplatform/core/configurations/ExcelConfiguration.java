package com.fxtech.ldplatform.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fxtech.excel.ExcelExporterImpl;
import com.fxtech.ldplatform.api.inters.excels.IExcelExporter;

@Configuration
class ExcelConfiguration {
	@Bean(name = "excelExporter")
	public IExcelExporter bindExcelBean() {
		return new ExcelExporterImpl();
	}
}
