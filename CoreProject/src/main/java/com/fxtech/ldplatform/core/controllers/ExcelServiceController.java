package com.fxtech.ldplatform.core.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.abstracts.excel.BaseExcel;

@RestController
@RequestMapping(value = "v1", method = { RequestMethod.POST })
public class ExcelServiceController {
	private Logger log = Logger.getLogger(ExcelServiceController.class);

	private @Autowired BaseExcel excelService;

	private ByteArrayOutputStream buffer;

	/**
	 * 生成要导出的Excel文件
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "exportExcel")
	public synchronized void exportData(String meta, String data, HttpServletResponse response) throws Exception {
		log.debug("User Request Export Data.");
		log.debug("Begin Export Data.");

		excelService.export(meta, data, buffer = new ByteArrayOutputStream());

		response.getWriter().write("{path: 'v1/exportDownload'}");
	}

	/**
	 * 已生成的Excel文件下载
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "exportDownload", method = RequestMethod.GET)
	public void exportDownload(HttpServletResponse response) throws Exception {
		response.reset();
		response.setContentType("application/msexcel;charset=UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=exportedData.xls");

		log.debug("End Export Data.");

		try {
			response.getOutputStream().write(buffer.toByteArray());
		} finally {
			buffer.close();
		}
	}

	/**
	 * 已生成的Excel文件下载
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "export2Excel/{service}/{method}", method = RequestMethod.GET)
	public void export2Excel(@PathVariable("service") String service, @PathVariable("method") String method,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.reset();
		response.setContentType("application/msexcel;charset=UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=exportedData.xls");

		Map<String, Object> params = readFromReqeust(request);
		Enumeration<String> names = request.getParameterNames();

		/**
		 * 因Mybatis使用map作为存储容器的时候，所有key会使用大写。为保持整体一致性， 所以从前台接收的所有参数转换为大写。
		 */
		for (; names.hasMoreElements();) {
			String name = names.nextElement();
			params.put(name.toUpperCase(), request.getParameter(name));
		}

		try {
			Object obj = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext())
					.getBean(service);
			List<Map> datas = (List<Map>) obj.getClass().getMethod(method, Map.class).invoke(obj, params);
		
			excelService.export(datas, buffer = new ByteArrayOutputStream());
			response.getOutputStream().write(buffer.toByteArray());
		} finally {
			buffer.close();
		}
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
}
