package com.fxtech.ldplatform.core.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fxtech.ldplatform.os.models.SystemUser;

/**
 * 模板引擎拦截器
 *
 * @author Ajaxfan
 */
@Controller
@RequestMapping(method = RequestMethod.GET)
public class DispacherController {
	/**
	 * 捕获系统页面的跳转操做
	 *
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "{path}")
	public String disp(@ModelAttribute("model") ModelMap model, @PathVariable("path") String path,
			HttpServletRequest request) {
		// 用户信息如果不存在，则说明session已经失效。应该让用户重新登录系统
		SystemUser user = (SystemUser) request.getSession().getAttribute("freeWayUser");
		model.addAttribute("modelName", user == null && !"stWhreport".equals(path) ? "exitSystem" : path);
		model.put("sysid", user == null ? "" : user.getSysid());

		return path.endsWith("Report") ? "report" : "func";
	}

	/**
	 * 系统登录
	 *
	 * @return
	 */
	@RequestMapping(value = "systemLogout")
	public String systemLogout(HttpServletRequest request) {
		// 移除用户的登录状态
		request.getSession().removeAttribute("freeWayUser");

		return "redirect:/console";
	}

	/**
	 * 系统主页处理器
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "main")
	public String main(@ModelAttribute("model") ModelMap model, HttpServletRequest request) {
		SystemUser user = (SystemUser) request.getSession().getAttribute("freeWayUser");

		// 如果用户登录信息不存在，则强制用户重新登陆
		if (user == null) {
			return "index";
		}
		model.put("username", user.getUsername());

		return "main";
	}

	/**
	 * 系统主页处理器
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "technicsPanel")
	public String technicsPanel(@ModelAttribute("model") ModelMap model, HttpServletRequest request) {
		Map user = (Map) request.getSession().getAttribute("technicsUser");

		// 如果用户登录信息不存在，则强制用户重新登陆
		if (user == null) {
			return "technics";
		}
		model.putAll(user);
		model.put("modelName", "1".equals(user.get("EM_MONITOR")) ? "monitor" : "container");

		return "technicsPanel";
	}

	/**
	 * 管理系统登录页面处理
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "nav";
	}

	/**
	 * 管理系统登录页面处理
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "ratio")
	public String ratio() {
		return "ratio";
	}

	/**
	 * 管理系统登录页面处理
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "kanban")
	public String kanban() {
		return "kanban";
	}

	/**
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "fapao")
	public String fapao() {
		return "fapao";
	}

	/**
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "fengpi")
	public String fengpi() {
		return "fengpi";
	}

	@RequestMapping(value = "zhuangpei")
	public String zhuangpei() {
		return "zhuangpei";
	}

	@RequestMapping(value = "repair")
	public String repair() {
		return "repair";
	}

	@RequestMapping(value = "slice")
	public String slice() {
		return "slice";
	}

	@RequestMapping(value = "report")
	public String report() {
		return "report";
	}

	/**
	 * 管理系统登录页面处理
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "storage")
	public String storage() {
		return "storage";
	}
	
	@RequestMapping(value = "jiare")
	public String jiare() {
		return "jiare";
	}
	
	@RequestMapping(value = "liangshai")
	public String liangshai() {
		return "liangshai";
	}

	/**
	 * 管理系统登录页面处理
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "console")
	public String console() {
		return "index";
	}

	/**
	 * 工艺文件无纸化录入
	 * 
	 * @param model
	 *            模型对象
	 * @return 要加载模板名称
	 */
	@RequestMapping(value = "technics")
	public String technics() {
		return "technics";
	}
}
