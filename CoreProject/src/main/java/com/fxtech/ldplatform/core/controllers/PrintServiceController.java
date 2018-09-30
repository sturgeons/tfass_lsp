package com.fxtech.ldplatform.core.controllers;

import java.awt.print.PrinterJob;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.abstracts.services.BasePrintService;
import com.fxtech.ldplatform.md.services.MDdictionaryService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 * 打印服务接口
 * 
 * @author Ajaxfan
 */
@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(value = "v1/printService", method = RequestMethod.POST)
public class PrintServiceController {
	private @Autowired MDdictionaryService mddictionaryService;

	/**
	 * 调用指定的打印服务
	 * 
	 * @param service
	 *            服务名称
	 * @param meta
	 *            表格头信息
	 * @param data
	 *            表格信息
	 * @param params
	 *            附加参数
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws JRException
	 */
	@RequestMapping("{service}")
	public void dataList(@PathVariable("service") String serviceName, HttpServletRequest request)
			throws JRException, Exception {
		Map<String, Object> params = readFromReqeust(request);
		Enumeration<String> names = request.getParameterNames();

		/**
		 * 因Mybatis使用map作为存储容器的时候，所有key会使用大写。为保持整体一致性， 所以从前台接收的所有参数转换为大写。
		 */
		for (; names.hasMoreElements();) {
			String name = names.nextElement();
			params.put(name.toUpperCase(), request.getParameter(name));
		}

		BasePrintService service = (BasePrintService) WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext()).getBean(serviceName);

		print((JasperPrint) service.print(params));
	}

	/**
	 * 从Request Body中获取参数信息
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> readFromReqeust(HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			params.putAll(new ObjectMapper().readValue(request.getReader(), HashMap.class));
		} catch (Exception e) {
			// nothing
		}
		return params;
	}

	/**
	 * 报表打印
	 *
	 * @param jasperPrint
	 * @throws JRException
	 */
	private void print(JasperPrint jasperPrint) throws JRException {
		// 打印请求属性集合
		PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
		// 使用A4纸张
		printRequestAttributeSet.add(MediaSizeName.ISO_A4);

		// 实例化Jasper导出工具类
		JRPrintServiceExporter exporter = new JRPrintServiceExporter();
		// 设定导出文件对象
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// 设置打印机
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, getPrintService());
		// 设定导出工具参数
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
		// 设置打印机参数
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
				new HashPrintServiceAttributeSet());
		// 不显示页面设置对话框
		exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
		// 不显示打印机选择对话框
		exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

		// 执行打印操作
		exporter.exportReport();
	}

	private Object getPrintService() {
		String printer_name = mddictionaryService.findByKey("printer_name");

		for (PrintService obj : PrinterJob.lookupPrintServices()) {
			if (obj != null && obj.getName().equalsIgnoreCase(printer_name)) {
				return obj;
			}
		}
		return PrintServiceLookup.lookupDefaultPrintService();
	}
}
