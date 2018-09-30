package com.fxtech.ldplatform.core.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 通用服务访问接口
 * 
 * @author Ajaxfan
 */
@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(value = "v1", method = { RequestMethod.GET, RequestMethod.POST })
public class ServiceController {
	private Logger log = Logger.getLogger(ServiceController.class);

	/**
	 * 调用指定服务下的接口
	 * 
	 * @param service
	 *            服务名称
	 * @param method
	 *            方法名称
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{service}/{method}")
	public Object dataList(@PathVariable("service") String service, @PathVariable("method") String method,
			HttpServletRequest request) throws Exception {
		log.info("Request service: " + service);
		log.info("Request method: " + method);

		Map<String, Object> params = readFromReqeust(request);
		Enumeration<String> names = request.getParameterNames();

		/**
		 * 因Mybatis使用map作为存储容器的时候，所有key会使用大写。为保持整体一致性， 所以从前台接收的所有参数转换为大写。
		 */
		for (; names.hasMoreElements();) {
			String name = names.nextElement();
			params.put(name.toUpperCase(), request.getParameter(name));
		}
		Object obj = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean(service);

		return obj.getClass().getMethod(method, Map.class).invoke(obj, params);
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
