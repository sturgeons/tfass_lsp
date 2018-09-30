package com.fxtech.ldplatform.md.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.md.services.MDemployeeService;

/**
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class TechnicsLoginController {
	/** 用户服务接口类 */
	private @Autowired MDemployeeService mdemployeeService;

	/**
	 * @return 系统登录
	 */
	@RequestMapping("technicsLogin")
	public Object technicsLogin(HttpServletRequest request) {
		Map<String, Object> params = readFromReqeust(request);

		List<Map<String, ?>> users = mdemployeeService.find(params);

		if (users.size() == 0) {// 如果用户信息不存在，则提示用户错误原因
			return new FeedBackMessage(false, "用户名或密码不正确");
		}
		// 用户信息存在Session中
		request.getSession().setAttribute("technicsUser", users.get(0));

		return new FeedBackMessage(true);
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
		Enumeration<String> names = request.getParameterNames();

		/**
		 * 因Mybatis使用map作为存储容器的时候，所有key会使用大写。为保持整体一致性， 所以从前台接收的所有参数转换为大写。
		 */
		for (; names.hasMoreElements();) {
			String name = names.nextElement();
			params.put(name.toUpperCase(), request.getParameter(name));
		}
		return params;
	}
}
