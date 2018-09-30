package com.fxtech.ldplatform.core.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 应用异常拦截器，用来同意处理系统错误
 * 
 * @author Ajaxfan
 */
public class ErrorInterceptor implements HandlerInterceptor {
	private Logger log = Logger.getLogger(ErrorInterceptor.class);

	/**
	 * 通过判断Http头状态来控制系统页面的跳转
	 * 
	 * @param request
	 * @param response
	 * @param obj
	 * @param model
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView model)
			throws Exception {
		if (response.getStatus() == 404) {
			log.info("request path is not found.");
		}
	}

	/**
	 * 在请求前处理调用逻辑，因为我们的拦截器是用来捕获异常的，所以这里不需要队请求前进行处理，直接返回true即可
	 * 
	 * @param request
	 * @param response
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		// 在整个请求结束后被调用，因为我们目前的应用中不需要使用，因此这里暂时空着.
	}
}
